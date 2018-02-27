import React, { Component } from 'react';
import {MemoryRouter,Route} from 'react-router-dom'
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
                <MemoryRouter initialEntries={[ '/', '/stations' ]} initialIndex={0}>
                    <div>
                        <AppNavbar/>
                        <hr/>
                        <Route exact path="/"        component={WelcomePage}/>
                        <Route path="/stations"      component={StationsList}/>
                        <Route path="/tree/:id"      render={(props)=><TreeView {...props} isEdit={false}/>}/>
                        <Route path="/treeEdit/:id"  render={(props)=><TreeView {...props} isEdit={true}/>}/>
                    </div>
                </MemoryRouter>
            </div>
        );
    }
}
export default App