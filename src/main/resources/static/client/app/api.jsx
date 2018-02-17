const ENDPOINT = 'http://localhost:8080';
const stationApi = '/station/api?id=';
const stationsAll = '/station/all';
const usersAll = '/users/all';
const getOptions = {credentials: 'same-origin'};

export function getStation(stationId){
    return new Promise((resolve, reject) => {
        fetch(ENDPOINT  + stationApi + stationId, getOptions)
            .then(parseJSON)
            .then((response) => {
                if (response.ok) {
                    return resolve(response.json);
                }
                // extract the error from the server's json
                return reject(response.json.meta.error);
            })
            .catch((error) => reject({
                networkError: error.message,
            }));
    });
}

export function getAllStations(){
    return new Promise((resolve, reject) => {
        fetch(ENDPOINT  + stationsAll, getOptions)
            .then(parseJSON)
            .then((response) => {
                if (response.ok) {
                    return resolve(response.json);
                }
                // extract the error from the server's json
                return reject(response.json.meta.error);
            })
            .catch((error) => reject({
                networkError: error.message,
            }));
    });
}

export function getAllUsers(){
    return new Promise((resolve, reject) => {
        fetch(ENDPOINT  + usersAll, getOptions)
            .then(parseJSON)
            .then((response) => {
                if (response.ok) {
                    return resolve(response.json);
                }
                // extract the error from the server's json
                return reject(response.json.meta.error);
            })
            .catch((error) => reject({
                networkError: error.message,
            }));
    });
}

function parseJSON(response) {
    return new Promise((resolve) => response.json()
        .then((json) => resolve({
            status: response.status,
            ok: response.ok,
            json,
        })));
}

