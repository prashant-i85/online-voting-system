<!DOCTYPE html>
<html>
<head>
    <title>Vote</title>
    <script src="../js/validation.js"></script>
    <link rel="stylesheet" href="../css/style.css">
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
