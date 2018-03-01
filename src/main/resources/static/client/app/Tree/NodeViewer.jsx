import React from 'react';
import PropTypes from 'prop-types';
import StationTable from '../Station/StationTable.jsx'
import {Button} from 'react-bootstrap'

const HELP_MSG =            'Выберите секцию для просмотра...';
const HELP_MSG_EDIT_VIEW =  'Выберите секцию для редактирования...';

class NodeViewer extends React.Component {

    render() {

        let msg;

       if(this.props.isEdit){
           msg = HELP_MSG_EDIT_VIEW;
       } else{
           msg = HELP_MSG;
       }

        let data;

        if (!this.props.node || this.props.node.children) {
            data = msg;
        } else {
            data = <StationTable station={this.props.station} sectionId={this.props.node.id} isEdit={this.props.isEdit} fieldValueListGeneration={this.props.fieldValueListGeneration}/>;
        }
        return (
                <div>
                    {data}
                </div>
        );
    }
}
NodeViewer.propTypes = {
    node: PropTypes.object
};
export default NodeViewer;