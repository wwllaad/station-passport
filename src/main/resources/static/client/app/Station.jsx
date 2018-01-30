import React, { Component } from 'react';

class Station extends React.Component {
    constructor(props) {
        super(props);
    }


    render() {
        return (
            <tr>
                <td>{this.props.station.station_name}</td>
                <td>{this.props.station.section_name}</td>
                <td>{this.props.station.customfield_name}</td>
                <td>{this.props.station.customfield_type}</td>
                <td>{this.props.station.customfieldsvalue_text_value}</td>
                <td>{this.props.station.customfieldsvalue_numeric_value}</td>
            </tr>
    );
    }
}

export default Station;