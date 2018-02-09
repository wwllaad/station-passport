import React, { Component } from 'react';
import StationSimpleView from './StationSimpleView.jsx'

class StationsList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            stations: []
        };
    }

    componentDidMount() {
        this.loadStationsFromServer();
    }


    loadStationsFromServer() {
        fetch('http://localhost:8080/st/getAllStations',
            {credentials: 'same-origin'})
            .then((response) => response.json())
            .then((responseData) => {
                this.setState({
                    stations: responseData,
                });
            });
    }
    render() {

        while(!this.state.stations){
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
