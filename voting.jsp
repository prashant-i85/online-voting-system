<%@ page import="com.voting.model.Voter" %>
<%
    Voter voter = (Voter) session.getAttribute("voter");
    if (voter == null) {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Vote</title>
</head>
<body>
    <h1>Welcome, <%= voter.getName() %>!</h1>
    <form action="VotingServlet" method="post">
        <label>Select Candidate:</label>
        <select name="candidateId">
            <option value="1">Candidate 1</option>
            <option value="2">Candidate 2</option>
        </select>
        <br>
        <button type="submit">Submit Vote</button>
    </form>
</body>
</html>
