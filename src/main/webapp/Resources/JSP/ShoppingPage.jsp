<%@ page import="java.util.List" %>
<%@ page import="com.example.demo1.Model.dao.DAOLivre" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% DAOLivre daoLivre=DAOLivre.getInstance(); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Comment</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/lib/bootstrap/dist/css/bootstrap.min.css" />
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light bg-white border-bottom box-shadow mb-3">
            <div class="container">
                <a class="navbar-brand" href="./">First</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="navbar-collapse collapse d-sm-inline-flex justify-content-between">
                    <ul class="navbar-nav flex-grow-1">
                        <li class="nav-item">
                            <a class="nav-link text-dark">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" >Privacy</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="${pageContext.request.contextPath}/User/Comment" >Comment</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="${pageContext.request.contextPath}/logout" >Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <div class="container">
        <main role="main" class="pb-3">
            <H1>Bienvenu ${userName}</H1>
            <div class="col-md-9">
                <table>
                <form method="post" action="${pageContext.request.contextPath}/User/Panier">
                    <c:forEach items="${daolivre.livres}" var="livre">
                        <tr>
                        <input type="checkbox" name="livres[]" value="${livre.id}"/><br>
                        </tr>
                    </c:forEach>
                    <input type="submit" value="Add to cart" class="btn btn-primary" />
                </form>

                </table>
            </div>
        </main>
    </div>

    <footer class="border-top footer text-muted">
        <div class="container">
            &copy; 2022 - Test - <a >Privacy</a>
        </div>
    </footer>

    <script src="${pageContext.request.contextPath}/Resources/lib/jquery/dist/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/Resources/lib/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
