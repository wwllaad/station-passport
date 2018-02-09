import React, { Component } from 'react';
import "../css/App.css"

class WelcomePage extends React.Component {
    constructor(props) {
        super(props);
    }


    render() {
        return (
        <div>
            <h2>Сайт о метестанциях Крыма</h2>
            <h4>Для получения подробной информации - необходимо выбрать метеостанцию из списка.</h4>
        </div>
        );
    }
}

export default WelcomePage;
