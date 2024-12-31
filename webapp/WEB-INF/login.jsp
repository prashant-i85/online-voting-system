<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <script src="../js/validation.js"></script>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <h1>Login</h1>
    <form action="LoginServlet" method="post" onsubmit="return validateLogin()">
        <label>Email:</label>
        <input type="text" id="email" name="email" required>
        <label>Password:</label>
        <input type="password" id="password" name="password" required>
        <button type="submit">Login</button>
    </form>
    <a href="register.jsp">Register here</a>
</body>
</html>
