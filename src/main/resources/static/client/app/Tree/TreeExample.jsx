'use strict';

import React from 'react';
import {Treebeard, decorators} from 'react-treebeard';
import NodeViewer from './NodeViewer.jsx';
import {getTreeSections} from '../api.jsx'
import {Button} from 'react-bootstrap'
import {Link} from 'react-router-dom'
// import data from './data.jsx';
import styles from './styles.jsx';
import * as filters from './filter.jsx';


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

class TreeExample extends React.Component {
    constructor() {
        super();

        this.state = {data:[]};
        this.onToggle = this.onToggle.bind(this);
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
                    <NodeViewer node={cursor} stationId={stateData.id}/>
                </div>
                <div className="table-row">
                    <Button bsStyle="primary">
                        <Link to="/stations">Вернуться к списку станций</Link>
                    </Button>
                </div>
            </div>
        );
    }
}
// nodeviewer style
export default TreeExample;