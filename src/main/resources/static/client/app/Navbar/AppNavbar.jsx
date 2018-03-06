import React, { Component } from 'react';
import { Navbar, NavItem, Nav, NavDropdown, MenuItem } from "react-bootstrap";
import { NavLink } from 'react-router-dom'

class AppNavbar extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <Navbar inverse collapseOnSelect fixedTop={true}>
                <Navbar.Header>
                    <Navbar.Brand>
                        <NavLink to="/">Метеостанции Крыма</NavLink>
                    </Navbar.Brand>
                    <Navbar.Toggle />
                </Navbar.Header>
                <Navbar.Collapse>
                    <Nav>
                        <NavItem>
                          <NavLink to="/stations"
                                   activeStyle={{
                                       font: 'bold',
                                       color: '#5c728a',
                                       textDecoration: 'none'
                                   }}>
                              Список станций
                          </NavLink>
                        </NavItem>
                        <NavItem>
                            <NavLink to="/newstation"
                                     activeStyle={{
                                         font: 'bold',
                                         color: '#5c728a',
                                         textDecoration: 'none'
                                     }}>
                                Добавить станцию
                            </NavLink>
                        </NavItem>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        );
    }
}
export default AppNavbar;
