function validateLogin() {
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    if (email === "" || password === "") {
        alert("Email and Password cannot be empty.");
        return false;
    }
    return true;
}

function validateRegister() {
    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    if (name === "" || email === "" || password === "") {
        alert("All fields are required.");
        return false;
    }
    return true;
}
