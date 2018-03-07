import React, { Component } from 'react';
import SubmitButton from './SubmitButton.jsx'
import {addNewStation} from '../api.jsx'
import {Redirect} from 'react-router'

class AddNewStation extends React.Component {
    constructor(props, context) {
        super(props, context);
        this.state = {
            stationName: null,
            station: null,
            redirect: false
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({[event.target.name]: event.target.value});
    }

    handleSubmit(){
        addNewStation(this.state.stationName)
            .then((response) => response.json())
            .then(result => {this.setState({
                station: result,
                redirect: true
            })
            })
            .catch((status, err) => {
                console.log('error');
                console.log(err);
            });
    }

    render() {
        if(this.state.redirect) {
            return <Redirect push to={"/station/" + this.state.station.id}/>
        }
        return (
            <div id="alignXYcenterdiv" className="table-cell">
                <h4>Введите название станции</h4>
                <form className="form">
                    <input type="text" className="form-control"  name="stationName" onChange={this.handleChange}/>
                </form>
                <SubmitButton handleSubmit={this.handleSubmit}/>
            </div>
        );
    }
}
export default AddNewStation;