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
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th>Название метеостанции</th><th>Подробная информация</th>
                        </tr>
                    </thead>
                    <tbody>
                        {stationsList}
                    </tbody>
                </table>
            </div>
        );
    }
}
export default StationsList;
