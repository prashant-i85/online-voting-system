// Add an event listener to the form to validate input before submission
document.querySelector("form").addEventListener("submit", function (e) {
    // Get the values of the username and password fields
    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();

    // Validation flags
    let isValid = true;
    let errorMessage = "";

    // Validate username
    if (username.length < 3) {
        isValid = false;
        errorMessage += "Username must be at least 3 characters long.\n";
    }

    // Validate password
    if (password.length < 6) {
        isValid = false;
        errorMessage += "Password must be at least 6 characters long.\n";
    }

    // Check for any validation errors
    if (!isValid) {
        // Prevent the form from submitting
        e.preventDefault();

        // Display the error message to the user
        alert(errorMessage);
    }
});
