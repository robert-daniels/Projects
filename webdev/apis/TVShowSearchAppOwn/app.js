let searchForm = document.getElementById('searchForm');
let searchButton = document.getElementById('userSearchButton');
let resultsDiv = document.getElementById('searchResults');

searchForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    let userSearch = searchForm.elements.userSearch.value;
    resultsDiv.innerHTML = '';
    
    const apiConfig = {
        params: {
            q: userSearch,
            isFunny: true
        }
    }

    const apiResponse = await axios.get('https://api.tvmaze.com/search/shows', apiConfig);
    console.log(apiResponse.data);
    displaySearchImages(apiResponse.data);
    searchForm.elements.userSearch.value = '';
    
})

const displaySearchImages = (shows) => {
    for (let result of shows){
        if (result.show.image){
            const showImage = document.createElement('IMG');
            showImage.src = result.show.image.medium;
            resultsDiv.append(showImage);
        }
    }
}