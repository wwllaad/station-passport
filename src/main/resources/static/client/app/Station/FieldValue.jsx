import React, { Component } from 'react';

class FieldValue extends React.Component {
    constructor(props) {
        super(props);
    }


    render() {
        let textValue = this.props.field.textValue;
        let numValue = this.props.field.intValue;
        let dataOut;

        if (textValue === "NULL"){
            dataOut = numValue;
        } else {
            dataOut = textValue;
        }
        return(
            <div className="table-cell">{dataOut}</div>
        )
    }
}
export default FieldValue;