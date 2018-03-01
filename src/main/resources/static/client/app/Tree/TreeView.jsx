'use strict';

import React from 'react';
import {Treebeard, decorators} from 'react-treebeard';
import NodeViewer from './NodeViewer.jsx';
import SaveEditButton from './SaveEditButton.jsx';
import {getTreeSections, getStation, updateFieldValue} from '../api.jsx'
import {Button} from 'react-bootstrap'
import styles from './styles.jsx';
import * as filters from './filter.jsx';
import Alert from 'react-s-alert';
import 'react-s-alert/dist/s-alert-default.css';
import 'react-s-alert/dist/s-alert-css-effects/slide.css';

const updateFieldValueUrl = 'section/update';


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
        this.updateFieldValue = this.updateFieldValue.bind(this);
        this.inverseEditState = this.inverseEditState.bind(this);
        this.loadTreeSections = this.loadTreeSections.bind(this);
        this.loadStationData = this.loadStationData.bind(this);
        this.setViewMode = this.setViewMode.bind(this);
        this.setEditMode = this.setEditMode.bind(this);
        this.testSubmit = this.testSubmit.bind(this);
        this.fieldValueListGeneration = this.fieldValueListGeneration.bind(this);
        this.state = {
            data:[],
            station: [],
            fieldValueList: [],
            isEdit: false,
            stationId: null
        };
    }

    componentDidMount() {
        this.setState({stationId: this.props.match.params.id});
        this.loadTreeSections(this.props.match.params.id);
        this.loadStationData(this.props.match.params.id)
    }

    loadTreeSections(stationId){
        getTreeSections(stationId).then(result => {
            this.setState({
                data: result})
        }).catch((status, err) => {
            console.log('err');
            console.log(err);
        });
    }

    loadStationData(stationId){
        getStation(stationId).then(result => {
            this.setState({
                station: result})
        })
            .catch((status, err) => {
                console.log('err');
                console.log(err);
            });
    }

    updateFieldValue(){
        console.log(this.state.fieldValueList);
        updateFieldValue(this.state.fieldValueList)
            .catch((status, err) => {
                console.log('err');
                console.log(err);
            });
    }

    setViewMode(event){
        event.preventDefault();
        this.updateFieldValue();
        this.loadStationData(this.state.stationId);
        this.inverseEditState();
    }

    setEditMode(event){
        event.preventDefault();
        this.loadStationData(this.state.stationId);
        this.inverseEditState();
    }

    inverseEditState(){
        this.setState({isEdit: !this.state.isEdit});
    }

    fieldValueListGeneration(id, fieldValue) {
        let IdFieldValuePair;

        if (typeof fieldValue === 'number' && (fieldValue % 1) === 0) {
            IdFieldValuePair = {
                id: id,
                intValue: fieldValue,
                textValue: ""
            };
        } else {
            IdFieldValuePair = {
                id: id,
                intValue: 0,
                textValue: fieldValue
            };
        }

        let tempFieldValueList = this.state.fieldValueList;

        if (!tempFieldValueList.length) {
            tempFieldValueList.push(IdFieldValuePair);
            this.setState({fieldValueList: tempFieldValueList});
        } else {
            for (let i = 0; i < tempFieldValueList.length; i++) {
                if (tempFieldValueList[i].id === IdFieldValuePair.id) {
                    tempFieldValueList.splice(i,1);
                }
            }
            tempFieldValueList.push(IdFieldValuePair);
            this.setState({fieldValueList: tempFieldValueList});
            }
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

    testSubmit(event) {
        console.log(this.state.fieldValueList);
        event.preventDefault();
        fetch(updateFieldValueUrl,
            {   method: 'PATCH',
                credentials: 'same-origin',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(this.state.fieldValueList)
            })
            .then(
                () => {this.loadStationData(this.state.stationId)}
            )
            .then(
                ()=>{
                    Alert.success("Отредактировано элементов: " + this.state.fieldValueList.length + " шт.",
                        {
                            position: 'top-right',
                            effect: 'slide',
                            offset: 200
                        });
                }
            )
            .then(
                ()=>{this.setState({ fieldValueList: []})}
            )
            .then(this.inverseEditState)
            .catch( err => console.error(err));
    }

    render() {

        const {data: stateData, cursor} = this.state;

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
                    <NodeViewer node={cursor} station={this.state.station} isEdit={this.state.isEdit} fieldValueListGeneration={this.fieldValueListGeneration}/>
                </div>
                <SaveEditButton isEdit={this.state.isEdit} testSubmit={this.testSubmit} setEditMode={this.setEditMode}/>
                <Alert stack={true} timeout={5000} />
            </div>
        );
    }
}
export default TreeView;