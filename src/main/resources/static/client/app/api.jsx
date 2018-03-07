const stationApiUrl = '/station/api?id=';
const stationDTOUrl = '/station/byid?id=';
const deleteStationByIdUrl = '/station/delete?id=';
const stationsAllUrl = '/station/all';
const usersAllUrl = '/users/all';
const treeSectionsUrl= 'section/treeformsections?id=';
const updateFieldValueUrl = 'section/update';
function addBlankFieldUrl(stationId, sectionId) {
    return  ('section/addsectionfields?stationId='+stationId+'&sectionId='+sectionId)
}
const addNewStationUrl = 'station/add?name=';

const getOptions = {credentials: 'same-origin'};
function patchOptions(data) {
    return({
        method: 'PATCH',
        credentials: 'same-origin',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
}

export function getStation(stationId){
    return fetch(stationApiUrl + stationId, getOptions)
}

export function getSimpleDTOStation(stationId){
    return fetch(stationDTOUrl + stationId, getOptions)
}

export function getAllStations(){
    return fetch(stationsAllUrl, getOptions)
}


export function getAllUsers(){
    return fetch(usersAllUrl, getOptions)
}

export function getTreeSections(stationId){
        return fetch(treeSectionsUrl + stationId, getOptions)
    }

export function updateFieldValue(data) {
    return fetch(updateFieldValueUrl,patchOptions(data));
}

export function addBlankField(stationId, sectionId) {
    return fetch(addBlankFieldUrl(stationId, sectionId), getOptions)
}

export function addNewStation(stationName) {
    return fetch(addNewStationUrl+stationName, getOptions)
}

export function deleteStationById(id) {
    return fetch(deleteStationByIdUrl+id, getOptions)
}


