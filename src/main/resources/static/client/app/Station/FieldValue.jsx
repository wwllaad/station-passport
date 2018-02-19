import React, { Component } from 'react';

class FieldValue extends React.Component {
    constructor(props) {
        super(props);
    }


    render() {

        let textValue = this.props.field.textValue;
        let numValue = this.props.field.intValue;

        if (numValue !== 0){
            return(
                <div className="table-cell">{numValue}</div>
            )
        } else {
            return (
                <div className="table-cell">{textValue}</div>
            )
        }
    }
}
export default FieldValue;