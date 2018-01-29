import React, { Component } from 'react';
// import "bootstrap/dist/css/bootstrap.css"

import User from './User.jsx'

class UserTable extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        var users = this.props.users.map(user =>
            <User key={user.id} user={user}/>
        );
        return (
            <div>
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th><th>Username</th><th>Phone</th>
                    </tr>
                    </thead>
                    <tbody>{users}</tbody>
                </table>
            </div>
            );
    }
}
export default UserTable;




