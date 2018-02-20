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

        getAllStations().then(result => {
            this.setState({
                stations: result})
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
                    <div className="table-header-group">
                        <div className="table-row">
                            <div className="table-cell">Название метеостанции</div>
                            <div className="table-cell">Подробная информация</div>
                        </div>
                    </div>
                    <div className="table-row-group">
                        {stationsList}
                    </div>
                </div>
            </div>
        );
    }
}
export default StationsList;
