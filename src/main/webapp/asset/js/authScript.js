const sign_up_btn = document.getElementById("upBtn");
const sign_in_btn = document.getElementById("inBtn");
const sign_in_form = document.getElementById("sign-in");
const sign_up_form = document.getElementById("sign-up");


sign_up_btn.addEventListener('click', () => {
    sign_in_form.classList.add('active');
    sign_up_form.classList.add('active');
});

sign_in_btn.addEventListener('click', () => {
    sign_in_form.classList.remove('active');
    sign_up_form.classList.remove('active');
});