import React, { Component } from 'react';

class FieldValueEdit extends React.Component {
    constructor(props, context) {
        super(props, context);
        this.state = {
            fieldValueId: null,
            fieldValue: ""
        };
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        this.setState({[event.target.name]: event.target.value});
        this.props.fieldValueListGeneration(this.state.fieldValueId, event.target.value)
    }

    componentDidMount() {

        this.setState(
            {fieldValueId: this.props.field.id}
        );

        let textValue = this.props.field.textValue;
        let numValue = this.props.field.intValue;

        if (textValue === "NULL"){
            this.setState({fieldValue:numValue})
        } else {
            this.setState({fieldValue:textValue})
        }
    }

    render() {
        return (
            <div className="table-cell">
                <form className="form">
                        <input type="text" className="form-control"  name="fieldValue" value={this.state.fieldValue} onChange={this.handleChange}/>
                </form>
            </div>
        );
    }
}
export default FieldValueEdit;