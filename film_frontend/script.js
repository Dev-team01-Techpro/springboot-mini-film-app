let films = [];

function addFilm() {
    const filmName = document.getElementById('filmName').value;
    const releaseYear = document.getElementById('releaseYear').value;
    const imdbRating = document.getElementById('imdbRating').value;
    const producer = document.getElementById('producer').value;
    const genre = document.getElementById('genre').value;

    const film = {
        filmName,
        releaseYear,
        imdbRating,
        producer,
        genre
    };

    if (imdbRating < 0) {
        alert('IMDb puanı negatif olamaz!');
        return;
    }

    // Make a POST request to add the film
    fetch('http://localhost:8080/films', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(film),
    })
    .then(response => response.json())
    .then(data => {
        films.push(data); 
        displayFilmList();
    })
    .catch(error => console.error('Error:', error));

    document.getElementById('filmForm').reset();
}

function displayFilmList() {
    fetch('http://localhost:8080/films')
        .then(response => response.json())
        .then(data => {
            films = data; 
            const filmList = document.getElementById('filmList');
            filmList.innerHTML = '';

            const filmTable = document.createElement('table');
            filmTable.innerHTML = `<tr>
                                        <th>Film Adı</th>
                                        <th>Gösterim Yılı</th>
                                        <th>IMDb Puanı</th>
                                        <th>Yapımcı</th>
                                        <th>Tür</th>
                                    </tr>`;

            films.forEach((film, index) => {
                const tableRow = document.createElement('tr');
                tableRow.innerHTML = `<td>${film.filmName}</td>
                                            <td>${film.releaseYear}</td>
                                            <td>${film.imdbRating}</td>
                                            <td>${film.producer}</td>
                                            <td>${film.genre}</td>`;
                filmTable.appendChild(tableRow);
            });

            filmList.appendChild(filmTable);
        })
        .catch(error => console.error('Error:', error));
}

displayFilmList();
