import React, { Component } from 'react';
import StationTable from './StationTable.jsx'

class StationView extends React.Component {
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
        fetch('http://localhost:8080/st/api?id=1',
            {credentials: 'same-origin'})
            .then((response) => response.json())
            .then((responseData) => {
                this.setState({
                    stations: responseData,
                });
            });
    }
    render() {
        return (
            <div>
                <StationTable stations={this.state.stations}/>
            </div>
        );
    }
}
export default StationView;
