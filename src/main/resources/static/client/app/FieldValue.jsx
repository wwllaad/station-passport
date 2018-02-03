import React, { Component } from 'react';

class FieldValue extends React.Component {
    constructor(props) {
        super(props);
    }


    render() {

        let textValue = this.props.field.textValue;
        let numValue = this.props.field.intValue;

        if (numValue != 0){
            return(
                <tr>{numValue}</tr>
            )
        } else {
            return (
                <tr>{textValue}</tr>
            )
        }
    }
}
export default FieldValue;