import React, { Component } from 'react';
import { Navbar, NavItem, Nav, NavDropdown, MenuItem } from "react-bootstrap";
import {Link} from 'react-router-dom'
import "../css/App.css"

class AppNavbar extends React.Component {
    constructor(props) {
        super(props);
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick(event){
    this.props.setActiveView(event.target.name)
    }

    render() {
        return (
            <Navbar inverse collapseOnSelect>
                <Navbar.Header>
                    <Navbar.Brand>
                        <Link to="/">Метеостанции Крыма</Link>
                    </Navbar.Brand>
                    <Navbar.Toggle />
                </Navbar.Header>
                <Navbar.Collapse>
                    <Nav>
                        <NavItem>
                          <Link to="/stations">Список станций</Link>
                        </NavItem>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        );
    }
}
export default AppNavbar;
