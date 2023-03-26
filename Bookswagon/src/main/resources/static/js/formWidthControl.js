function toggleFormWidthClass(x) {
    const formContainer = document.getElementById("form-container");
    x.matches ? formContainer.classList.toggle("w-100") : formContainer.classList.toggle("w-50");
}

const x = window.matchMedia("(max-width: 992px)");

toggleFormWidthClass(x);

window.addEventListener("resize", () => {
    toggleFormWidthClass(x);
});