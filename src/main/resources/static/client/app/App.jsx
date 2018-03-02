import React, { Component } from 'react';
import {HashRouter,Route} from 'react-router-dom'
import AppNavbar from './Navbar/AppNavbar.jsx'
import StationsList from './Stations/StationsList.jsx'
import WelcomePage from './StartPage/WelcomePage.jsx'
import TreeView from './Tree/TreeView.jsx'
import Footer from './Footer/Footer.jsx'

class App extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="wrapper">
                <div className="content">
                    <HashRouter initialEntries={[ '/', '/stations' ]} initialIndex={0}>
                        <div>
                        <AppNavbar/>
                        <Route exact path="/"        component={WelcomePage}/>
                        <Route path="/stations"      component={StationsList}/>
                        <Route path="/station/:id"   component={TreeView}/>
                        </div>
                    </HashRouter>
                </div>
                    <Footer/>
            </div>
        );
    }
}
export default App