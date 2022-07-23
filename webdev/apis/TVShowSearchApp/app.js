let form = document.getElementById('searchForm');

console.log(form);
form.addEventListener('submit', async function (e){
    e.preventDefault(); // important! form by default refreshes page. don't want this. 
    const userSearch = form.elements.showSearchQuery.value;
    const apiConfig = {
        params: { 
            q: userSearch
        }
    }
    const response = await axios.get('https://api.tvmaze.com/search/shows', apiConfig);
    console.log(response);
    displaySearchImages(response.data)
    form.elements.showSearchQuery.value = '';
    
})

const displaySearchImages = (shows) => {
    for (let result of shows){
        if (result.show.image){
            const showImage = document.createElement('IMG');
            showImage.src = result.show.image.medium;
            document.body.append(showImage);
        }
    }
}