import React, { Component } from 'react';
import {MemoryRouter,Route} from 'react-router-dom'
import AppNavbar from './AppNavbar.jsx'
import StationsList from './StationsList.jsx'
import StationView from './StationView.jsx'
import WelcomePage from './WelcomePage.jsx'

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