const artists = [
    { name: 'Artist One', id: 1 },
    { name: 'Artist Two', id: 2 },
    { name: 'Artist Three', id: 3 },
    { name: 'Artist Four', id: 4 },
    { name: 'Artist Five', id: 5 },
];

const artistsContainer = document.getElementById('artists');
const musicListContainer = document.getElementById('music-list');
const playerContainer = document.getElementById('player');
const searchInput = document.getElementById('search');

function renderArtists() {
    artistsContainer.innerHTML = '';
    artists.forEach(artist => {
        const artistCircle = document.createElement('div');
        artistCircle.className = 'artist-circle';
        artistCircle.textContent = artist.name.charAt(0);
        artistCircle.title = artist.name;
        artistCircle.onclick = () => {
            alert(`You clicked on ${artist.name}`);
        };
        artistsContainer.appendChild(artistCircle);
    });
}

function renderMusicList(list) {
    musicListContainer.innerHTML = '';
    list.forEach(music => {
        const musicItem = document.createElement('div');
        musicItem.className = 'music-item';
        musicItem.textContent = music.title;
        musicItem.onclick = () => {
            playerContainer.innerHTML = `<iframe src="${music.url}" width="300" height="80" frameborder="0" allowtransparency="true" allow="encrypted-media"></iframe>`;
        };
        musicListContainer.appendChild(musicItem);
    });
}

searchInput.addEventListener('input', (event) => {
    const searchTerm = event.target.value.toLowerCase();
    const filteredMusic = musicList.filter(music => music.title.toLowerCase().includes(searchTerm));
    renderMusicList(filteredMusic);
});

// Initial render of the artists and music list
renderArtists();
renderMusicList(musicList);
