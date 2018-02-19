var webpack = require('webpack');
var path = require('path');

var BUILD_DIR = path.resolve(__dirname, 'static/client/bundle');
var APP_DIR = path.resolve(__dirname, 'static/client/app');

var config = {
    entry:  APP_DIR + '/index.jsx',
    output: {
        path: BUILD_DIR,
        filename: 'bundle.js'
    },
    module : {
        rules : [
            {
                test : /\.jsx?/,
                include : APP_DIR,
                use : 'babel-loader'
            },
            {
                test: /\.css$/,
                use: [
                    "style-loader",
                    "css-loader"
                ]
            },
            {
                test: /\.(jpe?g|png|gif|svg)$/i,
                use: "url-loader?name=app/images/[name].[ext]"
            }
        ]
    }
};

module.exports = config;