import React, { Component } from 'react';
import FieldName from './FieldName.jsx';
import FieldValue from './FieldValue.jsx';
import FieldValueEdit from './FieldValueEdit.jsx';

class Section extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {

        if(this.props.sectionId !== this.props.section.id){
            return null;
        }
        let fieldName = this.props.section.customFieldDTOList.map(field =>
            <FieldName key={field.id} field={field}/>);

        let fieldValue;

        if(this.props.isEdit){
            fieldValue = this.props.section.customFieldValueDTOList.map(field =>
                <FieldValueEdit key={field.id} field={field} fieldValueListGeneration={this.props.fieldValueListGeneration}/>);
        } else {
            fieldValue = this.props.section.customFieldValueDTOList.map(field =>
                <FieldValue key={field.id} field={field}/>);
        }

        let fieldValuesFormatted = [];
        let fieldValuesBuffer = [];
        let fieldNameCounter = 0;

        for(let i=0;i<fieldValue.length;i++){

            fieldNameCounter++;
            fieldValuesBuffer.push(fieldValue[i]);

            if(fieldNameCounter === fieldName.length){
                fieldValuesFormatted.push(<div className="table-row">{fieldValuesBuffer}</div>);
                fieldValuesBuffer = [];
                fieldNameCounter = 0;
            }
        }
        return (
            <div className="table">
                <div className="table-row-group">
                    <div className="table-row">
                        <div className="table-row">{fieldName}</div>

                        {fieldValuesFormatted}

                    </div>
                </div>
            </div>
    );
    }
}
export default Section;