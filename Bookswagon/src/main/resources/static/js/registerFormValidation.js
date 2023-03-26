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


//FIRST NAME
  
const firstNameInput = document.getElementById("firstName");
const firstNameError = document.getElementById("firstNameError");
firstNameInput.addEventListener("blur", function() {
    validateInput(firstNameInput, firstNameError, 2, 50);
});
  
//LAST NAME

const lastNameInput = document.getElementById("lastName");
const lastNameError = document.getElementById("lastNameError");
lastNameInput.addEventListener("blur", function() {
    validateInput(lastNameInput, lastNameError, 2, 50);
});

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

//CONFIRM PASSWORD

const confirmPasswordInput = document.getElementById("confirmPassword");
const confirmPasswordError = document.getElementById("confirmPasswordError");
confirmPasswordInput.addEventListener("blur", function() {
    if (confirmPasswordInput.value !== passwordInput.value) {
        confirmPasswordInput.classList.add("is-invalid");
        confirmPasswordError.textContent = "Passwords must be the same!";
        confirmPasswordError.style.display = "block";
    } else {
        confirmPasswordInput.classList.remove("is-invalid");
        confirmPasswordInput.classList.add("is-valid");
        confirmPasswordError.style.display = "none";
    }
});

//EMAIL

const emailInput = document.getElementById("email");

emailInput.addEventListener("blur", function() {
  const value = emailInput.value.trim();
  const errorMessage = document.getElementById("emailError");

  if (value.length === 0 || value.length > 100) {
    emailInput.classList.add("is-invalid");
    errorMessage.textContent = "Email must be between 1 and 100 characters.";
    errorMessage.style.display = "block";
  } else if (!/\S+@\S+\.\S+/.test(value)) {
    emailInput.classList.add("is-invalid");
    errorMessage.textContent = "Please enter a valid email address.";
    errorMessage.style.display = "block";
  } else {
    emailInput.classList.remove("is-invalid");
    emailInput.classList.add("is-valid");
    errorMessage.style.display = "none";
  }
});
