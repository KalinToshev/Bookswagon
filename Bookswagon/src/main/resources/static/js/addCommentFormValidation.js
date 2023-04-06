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

//CONTENT

const contentInput = document.getElementById("content");
const contentError = document.getElementById("contentError");
contentInput.addEventListener("blur", function() {
    validateInput(contentInput, contentError, 20, 350);
});