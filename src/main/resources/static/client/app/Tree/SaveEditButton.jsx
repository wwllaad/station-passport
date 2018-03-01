import React, { Component } from 'react';
import {Button} from 'react-bootstrap'


class SaveEditButton extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {

        let button;

        if(this.props.isEdit){
            button =<div className="table-row">
                <Button bsStyle="success" onClick={this.props.testSubmit}>
                    Сохранить
                </Button>
            </div>;
        } else {
            button = <div className="table-row">
                <Button bsStyle="danger" onClick={this.props.setEditMode}>
                    Редактировать
                </Button>
            </div>;
        }

        return (
            <div>
                {button}
            </div>
        );
    }
}
export default SaveEditButton;
