// axios
//   .get("https://swapi.dev/api/people/1/")
//   .then((res) => {
//     console.log("RESPONSE: ", res);
//   })
//   .catch((e) => {
//     console.log("ERROR! ", e);
//   });

axios.get("https://swapi.dev/api/people/1/")
.then((res) => {
  console.log("RESPONSE: ", res);
})
.catch((e) => {
  console.log("Error found in swapi response: ", e);
})



const getStarWarsPerson = async (id) => {
  try {
    const res = await axios.get(`https://swapi.dev/api/people/${id}/`);
    console.log(res.data);
  } catch (e) {
    console.log("ERROR", e);
  }
};

let starWarsPeople = [1, 2, 3, 4, 5];

getStarWarsPerson(5);
getStarWarsPerson(10);

