import React, { Component } from 'react';
import {Button} from 'react-bootstrap'
import {Link} from 'react-router-dom'

class SubmitButton extends React.Component {
    constructor(props) {
        super(props);
        this.onClick=this.onClick.bind(this);
    }

    onClick(event){
        event.preventDefault();
        this.props.handleSubmit();
    }

    render() {
        return (
            <div className="submit-new-station-button">
                <Button bsStyle="primary" onClick={this.onClick}>
                    Добавить
                </Button>
            </div>
        );
    }
}
export default SubmitButton;
