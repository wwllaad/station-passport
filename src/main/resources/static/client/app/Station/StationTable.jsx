import React, { Component } from 'react';
import Section from './Section.jsx'
import {Button} from 'react-bootstrap'

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
        let sections = this.props.station.sections.map(section =>
            <Section key={section.id} section={section} sectionId={this.props.sectionId} isEdit={this.props.isEdit} fieldValueListGeneration={this.props.fieldValueListGeneration}/>
        );
        return (
            <div className="table">
                {sections}
            </div>
        );
    }
}
export default StationTable;




