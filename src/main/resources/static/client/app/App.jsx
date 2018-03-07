import React, { Component } from 'react';
import {HashRouter,Route} from 'react-router-dom'
import AppNavbar from './Navbar/AppNavbar.jsx'
import StationsList from './Stations/StationsList.jsx'
import WelcomePage from './StartPage/WelcomePage.jsx'
import TreeView from './Tree/TreeView.jsx'
import Footer from './Footer/Footer.jsx'
import AddNewStation from './AddNewStation/AddNewStation.jsx'
import DeleteStation from './DeleteStation/DeleteStation.jsx'

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
                        <Route exact path="/"               component={WelcomePage}/>
                        <Route path="/stations"             component={StationsList}/>
                        <Route path="/station/:id"          component={TreeView}/>
                        <Route path="/newstation"           component={AddNewStation}/>
                        <Route path="/deletestation/:id"    component={DeleteStation}/>
                        </div>
                    </HashRouter>
                </div>
                    <Footer/>
            </div>
        );
    }
}
export default App