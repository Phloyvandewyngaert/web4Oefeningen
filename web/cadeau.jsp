<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Cadeau" />
</jsp:include>
<%-- polling - client vraagt server voor vriendenlijst --%>
<body onload="getMyCadeaus()">
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Cadeau" />
</jsp:include>
<main>

    <h2>Jouw cadeaulijst</h2>
    <table>
        <thead>
        <tr>
            <th>omschrijving</th>
            <th>datumVanAanschafffing</th>
            <th>bestemdVoor</th>
            <th>prijs</th>
        </tr>
        </thead>
        <%-- hier komt de tabel van getmyfriends.js --%>
        <tbody id="myCadeaus">

        </tbody>
    </table>

    <%-- polling add --%>
    <h2>Voeg een vriend toe</h2>
    <%-- hiervan komen de gegevens die naar de js worden gestuurd--%>
    <input id="omschrijving" type="text" placeholder="omschrijving">
    <input id="datumVanAanschafffing" type="text" placeholder="datum">
    <input id="bestemdVoor" type="text" placeholder="bestemdVoor">
    <input id="prijs" type="text" placeholder="prijs">
    <button type="submit" onclick="addNewCadeau()">Add Cadeau</button>


</main>

<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
</body>
</html>
