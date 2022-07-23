// trying fetch without looking

const pullPerson = async (personID) => {
    fetch(`https://swapi.dev/api/people/${personID}/`)
    .then((res) => {
        console.log("Successful fetch: ", res);
        return res.json();
    })
    .then((data) => {
        console.log(data);
    })
    .catch ((e) => {
        console.log("Error occurred: ", e);
    })
}

const pullStarWarsPeople = async (id) => {
    await pullPerson(id);
};

pullStarWarsPeople(1);