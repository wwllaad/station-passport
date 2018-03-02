'use strict';

export default {
    component: {
        width: '30%',
        display: 'inline-block',
        verticalAlign: 'top',
        padding: '20px',
        '@media (maxWidth: 640px)': {
            width: '100%',
            display: 'block'
        }
    },
    searchBox: {
        width: '30%',
        padding: '20px 20px 0 20px'
    },
    table: {
        display: 'inline-block',
        verticalAlign: 'top',
        padding: '20px',
        '@media (maxWidth: 640px)': {
            width: '100%',
            display: 'block'
        }
    }
};



