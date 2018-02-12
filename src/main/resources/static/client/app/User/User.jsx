import React, { Component } from 'react';

class User extends React.Component {
    constructor(props) {
        super(props);
    }


    render() {
        return (
            <tr>
                <td>{this.props.user.id}</td>
                <td>{this.props.user.username}</td>
                <td>{this.props.user.phone}</td>
            </tr>
        );
    }


}

export default User;