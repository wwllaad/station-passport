import React, { Component } from 'react';
import UserTable from './UserTable.jsx'
import {getAllUsers} from '../api.jsx'

class UserView extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            users: []
        };
    }

    componentDidMount() {

        getAllUsers().then(result => {
            this.setState({
                users: result})
        }).catch((status, err) => {
            console.log('err');
            console.log(err);
        });
    }

    render() {
        return (
            <div>
                <UserTable users={this.state.users}/>
            </div>
        );
    }
}
export default UserView;
