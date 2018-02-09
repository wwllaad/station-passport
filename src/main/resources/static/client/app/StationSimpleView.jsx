import React, { Component } from 'react';
import {Link} from 'react-router-dom'
import {Button} from 'react-bootstrap'
import "../css/App.css"

class StationSimpleView extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {

        let id = this.props.station.id;
        return (
                <tr>
                    <td> {this.props.station.name}</td>
                    <td> <Button><Link to={"/station/" + id}>INFO</Link></Button></td>
                </tr>

        );
    }
}
export default StationSimpleView;