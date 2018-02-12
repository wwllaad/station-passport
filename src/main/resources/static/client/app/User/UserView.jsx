import React, { Component } from 'react';
import UserTable from './UserTable.jsx'

class UserView extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            users: []
        };
    }

    componentDidMount() {
        this.loadUsersFromServer();
    }


    loadUsersFromServer() {
        fetch('http://localhost:8080/users/all',
            {credentials: 'same-origin'})
            .then((response) => response.json())
            .then((responseData) => {
                this.setState({
                    users: responseData,
                });
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
