import React, { Component } from 'react';
import {MemoryRouter,Route} from 'react-router-dom'
import AppNavbar from './Navbar/AppNavbar.jsx'
import StationsList from './Stations/StationsList.jsx'
import StationView from './Station/StationView.jsx'
import WelcomePage from './StartPage/WelcomePage.jsx'

class App extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <MemoryRouter initialEntries={[ '/', '/stations' ]} initialIndex={0}>
                    <div>
                        <AppNavbar/>
                        <hr/>
                        <Route exact path="/" component={WelcomePage}/>
                        <Route path="/stations" component={StationsList}/>
                        <Route path="/station/:id" component={StationView}/>
                    </div>
                </MemoryRouter>
            </div>
        );
    }
}
export default App