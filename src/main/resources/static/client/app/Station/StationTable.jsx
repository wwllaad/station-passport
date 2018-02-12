import React, { Component } from 'react';
import Section from './Section.jsx'
import {Link} from 'react-router-dom'
import {Button} from 'react-bootstrap'
import "../../css/App.css"

class StationTable extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {

        while(!this.props.station.sections){
            return(
                <div>Loading....</div>
            )
        }

        let stationName = this.props.station.name;
        let sections = this.props.station.sections.map(section =>
            <Section key={section.id} section={section}/>
        );
        return (
            <div>
                <h3>{stationName}</h3>

                {sections}

                <Button>
                    <Link to="/stations">Вернуться к списку станций</Link>
                </Button>

            </div>
        );
    }
}
export default StationTable;




