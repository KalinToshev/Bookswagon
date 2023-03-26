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

//USERNAME

const usernameInput = document.getElementById("username");
const usernameError = document.getElementById("usernameError");
usernameInput.addEventListener("blur", function() {
    validateInput(usernameInput, usernameError, 3, 20);
});

//PASSWORD

const passwordInput = document.getElementById("password");
const passowrdError = document.getElementById("passwordError");
passwordInput.addEventListener("blur", function() {
    validateInput(passwordInput, passowrdError, 8, 20);
});