import React, { Component } from 'react';
import {HashRouter,Route} from 'react-router-dom'
import AppNavbar from './Navbar/AppNavbar.jsx'
import StationsList from './Stations/StationsList.jsx'
import WelcomePage from './StartPage/WelcomePage.jsx'
import TreeView from './Tree/TreeView.jsx'

class App extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <HashRouter initialEntries={[ '/', '/stations' ]} initialIndex={0}>
                    <div>
                        <AppNavbar/>
                        <hr/>
                        <Route exact path="/"        component={WelcomePage}/>
                        <Route path="/stations"      component={StationsList}/>
                        <Route path="/station/:id"   component={TreeView}/>
                    </div>
                </HashRouter>
            </div>
        );
    }
}
export default App