const ENDPOINT = 'http://localhost:8080';

export default function request(url, options) {
    return new Promise((resolve, reject) => {
        fetch(ENDPOINT  + url, options)
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
