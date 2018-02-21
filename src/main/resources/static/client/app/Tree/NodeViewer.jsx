import React from 'react';
import PropTypes from 'prop-types';
import styles from './styles.jsx';
import StationView from "../Station/StationView.jsx";

const HELP_MSG = 'Выберите секцию для просмотра...';

class NodeViewer extends React.Component {

    render() {

        const style = styles.viewer;
        let data;
        if (!this.props.node || this.props.node.children) {
            data = HELP_MSG;
        } else {
           data = <StationView stationId={this.props.stationId} sectionId={this.props.node.id}/>;
        }

        return <div>
            {data}
        </div>;
    }
}
NodeViewer.propTypes = {
    node: PropTypes.object
};
export default NodeViewer;