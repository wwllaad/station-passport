import React, { Component } from 'react';

class Section extends React.Component {
    constructor(props) {
        super(props);
    }


    render() {

        return (
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>{this.props.section.section_name}</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>{this.props.section.customfield_name}</tr>
                    <tr>{this.props.section.customfield_type}</tr>
                    <tr>{this.props.section.customfieldsvalue_text_value}</tr>
                    <tr>{this.props.section.customfieldsvalue_numeric_value}</tr>
                </tbody>
            </table>
    );
    }
}

export default Section;