<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vote for Your Candidate</title>
    <link rel="stylesheet" href="css/styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Online Voting System</h1>
        <p class="text-center">Vote for your preferred candidate below:</p>

        <!-- Success/Error Message -->
        <c:if test="${not empty message}">
            <div class="alert ${messageType} text-center">
                ${message}
            </div>
        </c:if>

        <!-- Candidate List -->
        <form action="servlets/VoteServlet" method="post">
            <div class="row">
                <c:forEach var="candidate" items="${candidates}">
                    <div class="col-md-4">
                        <div class="card text-center mb-3">
                            <div class="card-body">
                                <h5 class="card-title">${candidate.name}</h5>
                                <p class="card-text">${candidate.party}</p>
                                <input type="radio" name="candidateId" value="${candidate.id}" required>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary">Submit Your Vote</button>
            </div>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
