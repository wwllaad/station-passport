import React, { Component } from 'react';
import {Button} from 'react-bootstrap'

class NewFieldButton extends React.Component {
    constructor(props) {
        super(props);
        this.onClick=this.onClick.bind(this);
    }

    onClick(event){
        event.preventDefault();
        this.props.addBlankField(this.props.stationId, this.props.sectionId)
    }

    render() {
        return (
            <div className="custom-button" >
                <Button bsStyle="primary" onClick={this.onClick}>
                    +
                </Button>
            </div>
        );
    }
}
export default NewFieldButton;
