// get the joke

const getDadJoke = async () => { // async function returns promise
    try {
        const config = {
            headers: {Accept: 'application/json'} // per api documentation, have to pass a header config
        };
        const res = await axios.get('https://icanhazdadjoke.com/', config); // make the request with axios
        return res.data.joke; // return the unpacked request 
    }
    catch (e) {
        return "No jokes available, sorry";
    }
}

// add the joke to the DOM

let jokeList = document.getElementById('jokes');  // find the UL
let addJokeButton = document.getElementById('dadJokeButton'); // find the button

const addDadJoke = async () => {  // async function returns promise
    const data = await getDadJoke(); // wait for prommise return from api
    const newLI = document.createElement('LI'); // make a new LI element
    newLI.innerText = data; // load that new LI element with text
    jokeList.append(newLI); // append the new LI element to the UL
}

addJokeButton.addEventListener('click', addDadJoke); // add the eventListener