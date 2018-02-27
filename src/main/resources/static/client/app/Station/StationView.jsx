import React, { Component } from 'react';
import StationTable from './StationTable.jsx'
import {getStation} from '../api.jsx'

class StationView extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            station: []
        };
    }

    componentDidMount() {
        let stationId = this.props.stationId;

        getStation(stationId).then(result => {
            this.setState({
                station: result})
        }).catch((status, err) => {
            console.log('err');
            console.log(err);
        });
    }

    render() {
        return (
            <div>
                <StationTable station={this.state.station} sectionId={this.props.sectionId} isEdit={this.props.isEdit} fieldValueListGeneration={this.props.fieldValueListGeneration}/>
            </div>
        );
    }
}
export default StationView;
