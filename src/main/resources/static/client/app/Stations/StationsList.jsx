import React, { Component } from 'react';
import StationSimpleView from './StationSimpleView.jsx'
import {getAllStations} from '../api.jsx'

class StationsList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            stations: []
        };
    }

    componentDidMount() {

        getAllStations()
            .then((response) => response.json())
            .then(result => {this.setState({stations: result})
        }).catch((status, err) => {
            console.log('err');
            console.log(err);
        });
    }

    render() {
        if(!this.state.stations){
            return(
                <div>Loading....</div>
            )
        }
        let stationsList = this.state.stations.map(station =>
            <StationSimpleView key={station.id} station={station}/>);
        return (
            <div>
                <div id="station-list" className="table">
                    <div className="table-row-group">
                        {stationsList}
                    </div>
                </div>
            </div>
        );
    }
}
export default StationsList;
