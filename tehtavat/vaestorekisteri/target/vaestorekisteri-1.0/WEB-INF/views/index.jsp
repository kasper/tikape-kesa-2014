<%@ page contentType='text/html' pageEncoding='UTF-8' %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset='UTF-8'>
        <title>Väestörekisteri</title>
    </head>
    <body>

        <h1>Väestörekisteri</h1>

        <form method='POST' action='<c:url value='/' />'>
            <input type='text' name='id'>
            <input type='submit' value='Hae SOTU'>
        </form>

        <c:if test='${not empty citizens}'>

            <h2>Kansalainen</h2>

            <ul>
                <c:forEach var='citizen' items='${citizens}'>
                    <li>${citizen.firstname} ${citizen.lastname} (${citizen.id})</li>
                </c:forEach>
            </ul>

        </c:if>

        <c:if test='${citizens != null and empty citizens}'>
            <p>Ei tuloksia.</p>
        </c:if>

    </body>
</html>
