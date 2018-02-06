import React, { Component } from 'react';
import { Navbar, NavItem, Nav, NavDropdown, MenuItem, Button } from "react-bootstrap";
import UserView from './UserView.jsx'
import StationView from './StationView.jsx'
import AppNavbar from './AppNavbar.jsx'


class MainView extends React.Component {
    constructor(props) {
        super(props);
        this.setActiveView = this.setActiveView.bind(this);
        this.setAllViewStatesToFalse = this.setAllViewStatesToFalse.bind(this);
        this.state = {
            userView: false,
            stationsView: false
        };
    }

    setAllViewStatesToFalse(){
        this.setState({
            userView: false,
            stationsView: false
        });
    }

    setActiveView(activeView){

       this.setAllViewStatesToFalse();

        if(activeView === "userView"){
            this.setState({
                userView : true
            })
        }
        if(activeView === "stationsView"){
            this.setState({
                stationsView : true
            })
        }
    }

    render() {
        if (this.state.userView) {
            return (
                <div>
                    <AppNavbar setActiveView={this.setActiveView}/>
                    <UserView/>
                </div>
            )
        }
        if(this.state.stationsView){
            return(
                <div>
                    <AppNavbar setActiveView={this.setActiveView}/>
                    <StationView/>
                </div>
            )
        }
        return (
            <AppNavbar setActiveView={this.setActiveView}/>
        );
    }
}

export default MainView;
