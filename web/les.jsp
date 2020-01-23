<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Les" />
</jsp:include>
<%-- polling - client vraagt server voor vriendenlijst --%>
<body onload="getMyLessen()">
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Les" />
</jsp:include>
<main>

    <h2>Jouw lessenlijst</h2>
    <table>
        <thead>
        <tr>
            <th>dateLes</th>
            <th>naamLes</th>
            <th>lenLes</th>
        </tr>
        </thead>
        <%-- hier komt de tabel van getmyfriends.js --%>
        <tbody id="myLessen">

        </tbody>
    </table>



    <%-- polling add --%>
    <h2>Voeg een les toe</h2>
    <%-- hiervan komen de gegevens die naar de js worden gestuurd--%>
    <input id="dateLes" type="text" placeholder="datum">
    <input id="naamLes" type="text" placeholder="naam">
    <input id="lenLes" type="text" placeholder="duur">
    <button type="submit" onclick="addNewLes()">Add les</button>

</main>

<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
</body>
</html>

