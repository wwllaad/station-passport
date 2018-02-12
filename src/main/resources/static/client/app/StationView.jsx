import React, { Component } from 'react';
import StationTable from './StationTable.jsx'

class StationView extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            station: []
        };
    }

    componentDidMount() {
        this.loadStationFromServer();
    }


    loadStationFromServer() {
        let stationId = this.props.match.params.id;

        fetch('http://localhost:8080/station/api?id='+stationId,
            {credentials: 'same-origin'})
            .then((response) => response.json())
            .then((responseData) => {
                this.setState({
                    station: responseData,
                });
            });
    }
    render() {
        return (
            <div>
                <StationTable station={this.state.station}/>
            </div>
        );
    }
}
export default StationView;
