import React, { Component } from 'react';
import FieldName from './FieldName.jsx';
import FieldValue from './FieldValue.jsx';


class Section extends React.Component {
    constructor(props) {
        super(props);
    }


    render() {

        let sectionName = this.props.section.name;

        let fieldName = this.props.section.customFieldDTOList.map(field =>
            <FieldName key={field.id} field={field}/>);
        let fieldValue = this.props.section.customFieldValueDTOList.map(field =>
            <FieldValue key={field.id} field={field}/>);

        return (
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>{sectionName}</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>{fieldName}</td>
                        <td>{fieldValue}</td>
                    </tr>
                </tbody>
            </table>
    );
    }
}

export default Section;