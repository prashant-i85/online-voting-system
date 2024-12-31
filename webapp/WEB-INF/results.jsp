<!DOCTYPE html>
<html>
<head>
    <title>Results</title>
</head>
<body>
    <h1>Election Results</h1>
    <table>
        <tr>
            <th>Candidate Name</th>
            <th>Party</th>
            <th>Votes</th>
        </tr>
        <c:forEach var="candidate" items="${candidates}">
            <tr>
                <td>${candidate.name}</td>
                <td>${candidate.party}</td>
                <td>${candidate.votes}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
