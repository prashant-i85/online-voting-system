<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <script src="../js/validation.js"></script>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <h1>Register</h1>
    <form action="RegisterServlet" method="post" onsubmit="return validateRegister()">
        <label>Name:</label>
        <input type="text" id="name" name="name" required>
        <label>Email:</label>
        <input type="email" id="email" name="email" required>
        <label>Password:</label>
        <input type="password" id="password" name="password" required>
        <button type="submit">Register</button>
    </form>
    <a href="login.jsp">Back to login</a>
</body>
</html>
