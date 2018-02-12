import React, { Component } from 'react';
import StationTable from './StationTable.jsx'
import request from '../api.jsx'

class StationView extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            station: []
        };
    }

    componentDidMount() {
        let stationId = this.props.match.params.id;
        let url = '/station/api?id='+ stationId;
        let options = {credentials: 'same-origin'};

        request(url,options).then(result => {
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
                <StationTable station={this.state.station}/>
            </div>
        );
    }
}
export default StationView;
