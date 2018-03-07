import React, { Component } from 'react';
import DeleteButton from './DeleteButton.jsx'
import {Redirect} from 'react-router'
import {getSimpleDTOStation, deleteStationById} from '../api.jsx'
import Alert from 'react-s-alert';
import 'react-s-alert/dist/s-alert-default.css';
import 'react-s-alert/dist/s-alert-css-effects/slide.css';

class DeleteStation extends React.Component {
    constructor(props, context) {
        super(props, context);
        this.state = {
            isChecked: false,
            redirect: false,
            stationName: null,
            stationId: null
        };
        this.handleSubmit = this.handleSubmit.bind(this);
        this.toggleChange = this.toggleChange.bind(this);
        this.alertSuccessDelete = this.alertSuccessDelete.bind(this);
    }

    componentDidMount() {
        this.setState({stationId: this.props.match.params.id});
        getSimpleDTOStation(this.props.match.params.id)
            .then((response) => response.json())
            .then(json => {this.setState({stationName: json.name})
            })
            .catch((status, err) => {
                console.log('error');
                console.log(err);
            });
    }

    alertSuccessDelete(){
        Alert.error("Станция \"" + this.state.stationName + "\" - удалена",
            {
                position: 'top-right',
                effect: 'slide',
                offset: 30,
                timeout: 5000
            });
    }

    handleSubmit(){
        deleteStationById(this.state.stationId)
            .then(
                setTimeout(() => {
                    this.alertSuccessDelete();
                },50
            ))
            .then(()=>{
                this.setState({redirect: true});
                }
            )
            .catch((status, err) => {
                console.log('error');
                console.log(err);
            });
    }

    toggleChange(){
        this.setState({
            isChecked: !this.state.isChecked,
        });
    }

    render() {
        if(this.state.redirect) {
            return <Redirect push to="/stations"/>
        }
        let button = null;
        if(this.state.isChecked){
            button = <DeleteButton handleSubmit={this.handleSubmit}/>
        }
        let stationName = this.state.stationName;
        return (
            <div className="table">
                <div id="alignXYcenterdiv" className="table-row">
                    <div className="table-cell-delete-station">
                        <input type="checkbox" onChange={this.toggleChange}/>
                    </div>
                    <div className="table-cell-delete-station">
                        <label>  Подтвердите, что Вы хотите удалить станцию "{stationName}"</label>
                    </div>
                    {button}
                </div>
            </div>
        );
    }
}
export default DeleteStation;