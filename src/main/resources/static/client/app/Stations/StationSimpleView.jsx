import React, { Component } from 'react';
import {Link} from 'react-router-dom'
import {Button} from 'react-bootstrap'


class StationSimpleView extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {

        let id = this.props.station.id;
        return (
                <div className="table-row">
                    <div className="table-cell"> {this.props.station.name}</div>
                    <div className="table-cell"> <Button bsStyle="primary"><Link to={"/tree/" + id}>INFO</Link></Button></div>
                </div>

        );
    }
}
export default StationSimpleView;