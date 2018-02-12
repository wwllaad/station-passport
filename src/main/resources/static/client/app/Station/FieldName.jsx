import React, { Component } from 'react';

class FieldName extends React.Component {
    constructor(props) {
        super(props);
    }


    render() {

        let fieldName = this.props.field.name;

        return (
                <div>{fieldName}</div>
        );
    }
}

export default FieldName;