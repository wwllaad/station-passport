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
            <div className="table">
                <div className="table-row">
                    <h2>{stationName}</h2>
                </div>

                {sections}

                <div className="table-row">
                    <Button>
                        <Link to="/stations">Вернуться к списку станций</Link>
                    </Button>
                </div>

            </div>
        );
    }
}
export default StationTable;




