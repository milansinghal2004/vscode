const artists = [
    { name: 'Darshan Raval', id: 1 },
    { name: 'Arijit Singh', id: 2 },
    { name: 'Jubin Nautiyal', id: 3 },
    { name: 'Pritam', id: 4 },
    { name: 'KK', id: 5 }, 
];

const musicList = [
    { title: 'Mahiye Jinna Sona by Darshan Raval', artistId: 1, url: 'https://open.spotify.com/embed/track/0Jiaz0O4AqnJICa9PxHhaR?si=c3a30c8bb2b14c33' },
    { title: 'Mannat by Darshan Raval', artistId: 1, url: 'https://open.spotify.com/embed/track/26elzgFl8tvajnDfeoY1YF?si=15b23ab9b88b4588' },
    { title: 'Asal Mein by Darshan Raval', artistId: 1, url: 'https://open.spotify.com/embed/track/0rMeOAvbQZ2RTG4B6L1M4p?si=5adf3cc903f64275' },
    { title: 'Tu Hai by Darshan Raval', artistId: 1, url: 'https://open.spotify.com/embed/track/6cUOiOY5qh2FpIQWIYAd2h?si=d3f27bb7ce40463e' },
    { title: 'Meherma by Darshan Raval', artistId: 1, url: 'https://open.spotify.com/embed/track/6cUOiOY5qh2FpIQWIYAd2h?si=d3f27bb7ce40463e' },
    { title: 'Soni Soni by Darshan Raval', artistId: 1, url: 'https://open.spotify.com/embed/track/36N5awamOX6XX5pQn3aFXZ?si=8ca3a98367fb4fd3' },
    { title: 'Soulmate by Arijit Singh', artistId: 2, url: 'https://open.spotify.com/embed/track/1tf2iody5iRLYYPDSBpzRc?si=226589226bfc4829' },
    { title: 'Satranga by Arijit Singh', artistId: 2, url: 'https://open.spotify.com/embed/track/3yHyiUDJdz02FZ6jfUbsmY?si=f81dab5f0d014fec' },
    { title: 'Chaleya by Arijit Singh', artistId: 2, url: 'https://open.spotify.com/embed/track/3xMHXmedL5Rvfxmiar9Ryv?si=beeffb896c9045c9' },
    { title: 'O Maahi by Arijit Singh', artistId: 2, url: 'https://open.spotify.com/embed/track/6bmmHeCvZI92pRiTHxEdTC?si=60051d5d9a864b97' },
    { title: 'Sajni by Arijit Singh', artistId: 2, url: 'https://open.spotify.com/embed/track/5zCnGtCl5Ac5zlFHXaZmhy?si=326135aa8b5c4ad4' },
    { title: 'Apna Bana Le by Arijit Singh', artistId: 2, url: 'https://open.spotify.com/embed/track/5bQ6oDLqvw8tywmnSmwEyL?si=3de3ca12b2924a9f' },
    { title: 'Raatan Lambiyaan by Jubin Nautiyal', artistId: 3, url: 'https://open.spotify.com/embed/track/2rOnSn2piaqLAlYjtfUBlY?si=574b30b0f58b430a' },
    { title: 'Agar Tum Ho by Jubin Nautiyal', artistId: 3, url: 'https://open.spotify.com/embed/track/2JS0RFqBJvBtvG1GIsZmjW?si=72e462b6e810483d' },
    { title: 'Humnawa Mere by Jubin Nautiyal', artistId: 3, url: 'https://open.spotify.com/embed/track/0loZn1c5heXie7OAtvK6nH?si=401d2902c0f44efb' },
    { title: 'Tum Hi Aana by Jubin Nautiyal', artistId: 3, url: 'https://open.spotify.com/embed/track/6E9UwSfT80age2xknoMS7Y?si=46caa90e35d749af' },
    { title: 'Manike by Jubin Nautiyal', artistId: 3, url: 'https://open.spotify.com/embed/track/0zlGnseLGzRIBA0TJcb3Bo?si=a137c7b2814e4e15' },
    { title: 'Gazab Ka Hai Din by Jubin Nautiyal', artistId: 3, url: 'https://open.spotify.com/embed/track/4byiHL0b9mIoCUCjbjI4eA?si=8674eae1ead04418' },
    { title: 'Lambi Judaai by Pritam', artistId: 4, url: 'https://open.spotify.com/embed/track/3mFDF0ulC4tyOFC4bB67Kd?si=8e5a928014104f8f' },
    { title: 'Jannat Jahan by Pritam', artistId: 4, url: 'https://open.spotify.com/embed/track/39laDigENmKNlT94cnLWwr?si=8702ace460914653' },
    { title: 'Door Na Jaa by Pritam', artistId: 4, url: 'https://open.spotify.com/embed/track/1bXjyI1O0HAOMvFLYFqWAM?si=b3e4d9c519794c27' },
    { title: 'Haan tu Hai by Pritam', artistId: 4, url: 'https://open.spotify.com/embed/track/4vgCpNUUcpEIBifidhQOnR?si=d4847567b5ec45b7' },
    { title: 'Judai by Pritam', artistId: 4, url: 'https://open.spotify.com/embed/track/7LGgRybx6vnACSRnYcGmMl?si=eb2c027d26fd496d' },
    { title: 'Zara Sa by Pritam', artistId: 4, url: 'https://open.spotify.com/embed/track/18YHbIhrleUkKKj2DvEp79?si=5852985bb0c44a91' },
    { title: 'Kya mujhe Pyaar Hai by KK', artistId: 5, url: 'https://open.spotify.com/embed/track/3HFjh7QljnUCBLsoTwMuTj?si=d5e60b1e4bd748bc' },
    { title: 'Ajab Si by KK', artistId: 5, url: 'https://open.spotify.com/embed/track/2RgvvnMwtP0R2OkVZmFvnV?si=282bbb64402a4d46' },
    { title: 'Tu Hi Yaar Mera by KK', artistId: 5, url: 'https://open.spotify.com/embed/track/57jOEZtoLQK4zF2x55bdkp?si=5036ce76e0e940cd' },
    { title: 'Labon Ko by KK', artistId: 5, url: 'https://open.spotify.com/embed/track/0a1RgBxvN4gs3YAqxPI1N9?si=92ec6c190cec4ecd' },
    { title: 'Dil Ibaadat by KK', artistId: 5, url: 'https://open.spotify.com/embed/track/3Kl8p2PxVf8eAayLwTxOIm?si=b927a0d16d554d8d' },
    { title: 'Teri Yaadon Me by KK', artistId: 5, url: 'https://open.spotify.com/embed/track/4ZVfIGaZP93t0stmBj4FqA?si=bb9b33983bbc4be0' },
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
            renderMusicList(artist.id);
            setSelectedArtist(artistCircle);
        };
        artistsContainer.appendChild(artistCircle);
    });
}

function renderMusicList(artistId) {
    const filteredMusic = musicList.filter(music => music.artistId === artistId);
    musicListContainer.innerHTML = '';
    filteredMusic.forEach(music => {
        const musicItem = document.createElement('div');
        musicItem.className = 'music-item';
        musicItem.textContent = music.title;
        musicItem.onclick = () => {
            playerContainer.innerHTML = `<iframe src="${music.url}" width="300" height="80" frameborder="0" allowtransparency="true" allow="encrypted-media"></iframe>`;
        };
        musicListContainer.appendChild(musicItem);
    });
}

function setSelectedArtist(selectedCircle) {
    const artistCircles = document.querySelectorAll('.artist-circle');
    artistCircles.forEach(circle => {
        circle.classList.remove('selected');
    });
    selectedCircle.classList.add('selected');
}

searchInput.addEventListener('input', (event) => {
    const searchTerm = event.target.value.toLowerCase();
    const filteredMusic = musicList.filter(music => music.title.toLowerCase().includes(searchTerm));
    musicListContainer.innerHTML = '';
    filteredMusic.forEach(music => {
        const musicItem = document.createElement('div');
        musicItem.className = 'music-item';
        musicItem.textContent = music.title;
        musicItem.onclick = () => {
            playerContainer.innerHTML = `<iframe src="${music.url}" width="300" height="80" frameborder="0" allowtransparency="true" allow="encrypted-media"></iframe>`;
        };
        musicListContainer.appendChild(musicItem);
    });
});

renderArtists();