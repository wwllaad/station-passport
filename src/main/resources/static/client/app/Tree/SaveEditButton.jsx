import React, { Component } from 'react';
import {Button} from 'react-bootstrap'

class SaveEditButton extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        let button;
        if(this.props.isEdit){
            button = <Button bsStyle="success" onClick={this.props.setViewMode}>
                    Сохранить
                    </Button>;
        } else {
            button = <Button bsStyle="danger" onClick={this.props.setEditMode}>
                    Редактировать
                </Button>;
        }
        return (
            <div className="custom-button" >
                {button}
            </div>
        );
    }
}
export default SaveEditButton;
