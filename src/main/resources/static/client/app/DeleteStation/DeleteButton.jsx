import React, { Component } from 'react';
import {Button} from 'react-bootstrap'

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
                <Button bsStyle="danger" onClick={this.onClick}>
                    Удалить
                </Button>
            </div>
        );
    }
}
export default SubmitButton;
