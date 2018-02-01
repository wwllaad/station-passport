import React, { Component } from 'react';

class Station extends React.Component {
    constructor(props) {
        super(props);
    }


    render() {
        //
        // if(this.props.station.station_name !== this.props.station_name){
        //     this.props.setStationName(this.props.station.station_name);
        //     return (
        //         <tr>
        //             <td>{this.props.station.station_name}</td>
        //             <td>{this.props.station.section_name}</td>
        //             <td>{this.props.station.customfield_name}</td>
        //             <td>{this.props.station.customfield_type}</td>
        //             <td>{this.props.station.customfieldsvalue_text_value}</td>
        //             <td>{this.props.station.customfieldsvalue_numeric_value}</td>
        //         </tr>
        //     );
        // }

        return (
            <tr>
                <td>{this.props.station.id}</td>
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