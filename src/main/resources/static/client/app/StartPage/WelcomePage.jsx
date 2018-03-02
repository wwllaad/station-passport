import React, { Component } from 'react';
import "../../css/App.css"
import crimea1 from '../images/crimea1.jpg'
import crimea2 from '../images/crimea2.jpg'
import crimea3 from '../images/crimea3.jpg'
import { Carousel } from "react-bootstrap";


class WelcomePage extends React.Component {
    constructor(props) {
        super(props);
    }


    render() {
        return (
        <div>
            <Carousel>
                <Carousel.Item>
                    <img src={crimea1} alt="1280x750"/>
                    <Carousel.Caption>
                        <h2>Метеостанции Крыма</h2>
                        <h3>Для получения подробной информации - необходимо выбрать метеостанцию из списка</h3>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img src={crimea2} alt="1280x750"/>
                    <Carousel.Caption>

                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img src={crimea3} alt="1280x750"/>
                    <Carousel.Caption>

                    </Carousel.Caption>
                </Carousel.Item>
            </Carousel>;
        </div>
        );
    }
}

export default WelcomePage;
