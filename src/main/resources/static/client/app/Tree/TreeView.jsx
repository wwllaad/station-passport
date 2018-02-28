'use strict';

import React from 'react';
import {Treebeard, decorators} from 'react-treebeard';
import NodeViewer from './NodeViewer.jsx';
import {getTreeSections} from '../api.jsx'
import {Button} from 'react-bootstrap'
import {Link} from 'react-router-dom'
import styles from './styles.jsx';
import * as filters from './filter.jsx';
import {updateFieldValue} from '../api.jsx'


// Example: Customising The Header Decorator To Include Icons
decorators.Header = ({style, node}) => {
    const iconType = node.children ? 'folder' : 'file-text';
    const iconClass = `fa fa-${iconType}`;
    const iconStyle = {marginRight: '5px'};

    return (
        <div style={style.base}>
            <div style={style.title}>
                <i className={iconClass} style={iconStyle}/>

                {node.name}
            </div>
        </div>
    );
};

class TreeView extends React.Component {
    constructor() {
        super();
        this.onToggle = this.onToggle.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.fieldValueListGeneration = this.fieldValueListGeneration.bind(this);
        this.state = {
            data:[],
            fieldValueList: []
        };
    }

    fieldValueListGeneration(id, fieldValue){
        let IdFieldValuePair;

        if(typeof fieldValue==='number' && (fieldValue%1)===0){
            IdFieldValuePair = {
                id: id,
                intValue: fieldValue,
                textValue: ""
            };
        } else{
            IdFieldValuePair = {
                id: id,
                intValue: 0,
                textValue: fieldValue
            };
        }

        let tempFieldValueList = this.state.fieldValueList;

        if(!tempFieldValueList.length){
            tempFieldValueList.push(IdFieldValuePair);
            this.setState({ fieldValueList: tempFieldValueList});
        } else
            if(IdFieldValuePair.id === tempFieldValueList[tempFieldValueList.length-1].id){
            tempFieldValueList.pop();
            tempFieldValueList.push(IdFieldValuePair);
            this.setState({ fieldValueList: tempFieldValueList});
            } else {
                tempFieldValueList.push(IdFieldValuePair);
                this.setState({ fieldValueList: tempFieldValueList});
            }
    }

    handleSubmit(event){
        event.preventDefault();
        console.log(this.state.fieldValueList);
        updateFieldValue(this.state.fieldValueList)
            .catch((status, err) => {
            console.log('err');
            console.log(err);
        });

    }

    componentDidMount() {
        let stationId = this.props.match.params.id;

        getTreeSections(stationId).then(result => {
            this.setState({
                data: result})
        }).catch((status, err) => {
            console.log('err');
            console.log(err);
        });
    }

    onToggle(node, toggled) {
        const {cursor} = this.state;

        if (cursor) {
            cursor.active = false;
        }

        node.active = true;
        if (node.children) {
            node.toggled = toggled;
        }

        this.setState({cursor: node});
    }

    onFilterMouseUp(e) {
        const filter = e.target.value.trim();
        if (!filter) {
            this.componentDidMount();
        }
        let filtered = filters.filterTree(this.state.data, filter);
        filtered = filters.expandFilteredNodes(filtered, filter);
        this.setState({data: filtered});
    }

    render() {
        const {data: stateData, cursor} = this.state;

        let stationId = stateData.id;
        let button;

        if(this.props.isEdit){
            button =<div className="table-row">
                <Button bsStyle="success" onClick={this.handleSubmit}>
                    <Link to={"/station/" + stationId}>Сохранить</Link>
                </Button>
            </div>;
        } else{
            button = <div className="table-row">
                <Button bsStyle="danger">
                    <Link to={"/stationEditMode/" + stationId}>Редактировать</Link>
                </Button>
            </div>;
        }

        return (
            <div>
                <div style={styles.searchBox}>
                    <div className="input-group">
                        <span className="input-group-addon">
                          <i className="fa fa-search"/>
                        </span>
                        <input className="form-control"
                               onKeyUp={this.onFilterMouseUp.bind(this)}
                               placeholder="Поиск по дереву..."
                               type="text"/>
                    </div>
                </div>
                <div style={styles.component}>
                    <Treebeard data={stateData}
                               decorators={decorators}
                               onToggle={this.onToggle}
                               />
                </div>
                <div style={styles.component}>
                    <NodeViewer node={cursor} stationId={stateData.id} isEdit={this.props.isEdit} fieldValueListGeneration={this.fieldValueListGeneration}/>
                </div>
                {button}
            </div>
        );
    }
}
// nodeviewer style
export default TreeView;