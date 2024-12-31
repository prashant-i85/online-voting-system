<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form action="LoginServlet" method="post">
        <label>Email:</label>
        <input type="text" name="email" required>
        <label>Password:</label>
        <input type="password" name="password" required>
        <button type="submit">Login</button>
    </form>
    <a href="register.jsp">Register here</a>
</body>
</html>
