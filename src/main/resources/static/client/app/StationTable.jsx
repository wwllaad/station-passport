import React, { Component } from 'react';
import Section from './Section.jsx'

class StationTable extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {

        while(!this.props.stations.section){
            return(
                <div>Loading....</div>
            )
        }

        let stationName = this.props.stations.name;
        let stations = this.props.stations.section.map(section =>
            <Section key={section.id} section={section}/>
        );
        return (
            <div>
                <h3>{stationName}</h3>

                {stations}

            </div>
        );
    }
}
export default StationTable;




