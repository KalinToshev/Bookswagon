function validateInput(inputElement, errorMessageElement, minSize, maxSize) {
    const value = inputElement.value.trim();
    const errorMessage = errorMessageElement;

    if (value.length < minSize || value.length > maxSize) {
        inputElement.classList.add("is-invalid");
        errorMessage.textContent = `${inputElement.name} must be between ${minSize} and ${maxSize} characters, and must not contain only whitespace.`;
        errorMessage.style.display = "block";
    } else {
        inputElement.classList.remove("is-invalid");
        inputElement.classList.add("is-valid");
        errorMessage.style.display = "none";
    }
}

//TITLE

const titleInput = document.getElementById("title");
const titleError = document.getElementById("titleError");
titleInput.addEventListener("blur", function() {
    validateInput(titleInput, titleError, 2, 100);
});

//AUTHOR

const authorInput = document.getElementById("author");
const authorError = document.getElementById("authorError");
authorInput.addEventListener("blur", function() {
    validateInput(authorInput, authorError, 2, 100);
});

//DESCRIPTION

const descriptionInput = document.getElementById("description");
const descriptionError = document.getElementById("descriptionError");
descriptionInput.addEventListener("blur", function() {
    validateInput(descriptionInput, descriptionError, 50, 500);
});

//PUBLISH DATE

const publishDateInput = document.getElementById('publishDate');
const publishDateError = document.getElementById('publishDateError');

function validatePublishDate() {
    const publishDate = new Date(publishDateInput.value);

    if (publishDate.toString() === 'Invalid Date') {
        publishDateError.textContent = 'Publish date should not be empty.';
        publishDateInput.classList.remove('is-valid');
        publishDateInput.classList.add('is-invalid');
        return;
    }

    const now = new Date();

    if (publishDate > now) {
        publishDateError.textContent = 'Publish date should be in the past or present.';
        publishDateInput.classList.remove('is-valid');
        publishDateInput.classList.add('is-invalid');
        return;
    }

    publishDateError.textContent = '';
    publishDateInput.classList.remove('is-invalid');
    publishDateInput.classList.add('is-valid');
}

publishDateInput.addEventListener('blur', validatePublishDate);

//ISBN

const isbnInput = document.getElementById("isbn");
const isbnError = document.getElementById("isbnError");
isbnInput.addEventListener("blur", function() {
    validateInput(isbnInput, isbnError, 10, 13);
});

//LANGUAGE

const languageInput = document.getElementById("language");
const languageError = document.getElementById("languageError");
languageInput.addEventListener("blur", function() {
    validateInput(languageInput, languageError, 3, 30);
});

//PAGES COUNT

const pagesInput = document.getElementById('pages');
const pagesError = document.getElementById('pagesError');

function validatePages() {
    const pages = pagesInput.value;

    if (pages.trim() === '') {
        pagesError.textContent = 'Please enter a value for the number of pages.';
        pagesInput.classList.remove('is-valid');
        pagesInput.classList.add('is-invalid');
        return;
    }

    if (isNaN(pages) || pages <= 0) {
        pagesError.textContent = 'The page number should be a positive number.';
        pagesInput.classList.remove('is-valid');
        pagesInput.classList.add('is-invalid');
        return;
    }

    pagesError.textContent = '';
    pagesInput.classList.remove('is-invalid');
    pagesInput.classList.add('is-valid');
}

pagesInput.addEventListener('blur', validatePages);

//BOOK IMAGE URL
const bookImageUrl = document.getElementById('bookImageUrl');
const bookImageUrlError = document.getElementById('bookImageUrlError');

bookImageUrl.addEventListener('blur', () => {
    const urlPattern = /^(https?|ftp):\/\/[^\s/$.?#].[^\s]*$/i;
    if (!bookImageUrl.value.trim()) {
        bookImageUrlError.textContent = 'Book image URL is required and must not contain only whitespace.';
        bookImageUrl.classList.add('is-invalid');
    } else if (!urlPattern.test(bookImageUrl.value.trim())) {
        bookImageUrlError.textContent = 'Sorry, the image URL you entered is not recognized. Please enter a valid URL to continue.';
        bookImageUrl.classList.add('is-invalid');
    } else {
        bookImageUrlError.textContent = '';
        bookImageUrl.classList.remove('is-invalid');
        bookImageUrl.classList.add('is-valid');
    }
});
