<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Vote</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Vote in the Election</h1>
    <form action="VoteServlet" method="post">
        <input type="hidden" name="electionId" value="${electionId}">
        <h2>Select a Candidate</h2>
        <c:forEach var="candidate" items="${candidates}">
            <input type="radio" name="candidateId" value="${candidate.candidateId}" required>
            <label>${candidate.name} (${candidate.party})</label><br>
        </c:forEach>
        <button type="submit">Submit Vote</button>
    </form>
</body>
</html>
