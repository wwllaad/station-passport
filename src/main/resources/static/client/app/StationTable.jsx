
import React, { Component } from 'react';
// import "bootstrap/dist/css/bootstrap.css"

import Station from './Station.jsx'

class StationTable extends React.Component {
    constructor(props) {
        super(props);
        // this.setStationName = this.setStationName.bind(this);
        // this.state = {
        //     station_name: null
        // };
    }

    // setStationName(stationName){
    //     this.setState({
    //         station_name: stationName
    //     });
    // }

    render() {
        var stations = this.props.stations.map(station =>
            <Station key={station.id} station={station}/>
        );
        return (
            <div>
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <th>Станция</th>
                        <th>Заголовок</th>
                        <th>Информационное поле</th>
                        <th>Тип данных</th>
                        <th>Текстовые значения</th>
                        <th>Числовые значения</th>
                    </tr>
                    </thead>
                    <tbody>{stations}</tbody>
                </table>
            </div>
        );
    }
}
export default StationTable;




