const bookList = document.getElementById('bookList');

fetch('http://localhost:8000/api/books')
    .then(response => response.json())
    .then(data => {
        data.forEach(book => {
            const bookBox = document.createElement('div');
            bookBox.className = 'card text-dark m-2 p-0 rounded';
            bookBox.style = 'width: 18rem;';

            const img = document.createElement('img');
            img.className = 'card-img-top';
            img.src = book.bookImageUrl;
            img.alt = 'Card image cap';
            img.height = '200';
            bookBox.appendChild(img);

            const cardBody = document.createElement('div');
            cardBody.className = 'card-body d-flex flex-column justify-content-between text-center';
            bookBox.appendChild(cardBody);

            const title = document.createElement('h5');
            title.className = 'card-title';
            title.textContent = book.title;
            cardBody.appendChild(title);

            const separator = document.createElement('hr');
            separator.className = 'my-3 bg-dark w-100';
            cardBody.appendChild(separator);

            const description = document.createElement('p');
            description.className = 'card-text';
            description.textContent = book.description.substring(0, 90) + '...';
            cardBody.appendChild(description);

            const detailsBtn = document.createElement('a');
            const bookId = book.id;
            detailsBtn.className = 'btn btn-warning mt-2 mb-2 w-100 text-uppercase fw-bold shadow border border-dark text-white';
            detailsBtn.href = '/books/details/' + bookId;
            detailsBtn.textContent = 'More details';
            cardBody.appendChild(detailsBtn);

            const addBtn = document.createElement('a');
            addBtn.className = 'btn btn-warning mt-2 mb-2 w-100 text-uppercase fw-bold shadow border border-dark text-white';
            addBtn.href = '#';
            addBtn.textContent = 'Add to your book repo';
            cardBody.appendChild(addBtn);

            bookList.appendChild(bookBox);
        });
    })
    .catch(error => console.error(error));
