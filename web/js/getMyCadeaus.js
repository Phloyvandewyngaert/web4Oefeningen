var xHRObjectMyCadeaus = new XMLHttpRequest();//xhttp request object

//GetMyFriends
function getMyCadeaus() {
    xHRObjectMyCadeaus.open("GET", "Controller?action=GetMyCadeaus", true);
    xHRObjectMyCadeaus.onreadystatechange = getData;
    xHRObjectMyCadeaus.send(null);
}

function getData() {

    if (xHRObjectMyCadeaus.readyState === 4) {
        if (xHRObjectMyCadeaus.status === 200 || xHRObjectMyCadeaus.status === 500) {
            var jsonResponse = JSON.parse(xHRObjectMyCadeaus.responseText); //respons casten naar json

            var html = "";
            for (var i = 0; i < jsonResponse.length; i++) {
                var userId = jsonResponse[i].userId;
                html += "<tr>" +
                    "<td>" + jsonResponse[i].omschrijving + "</td>" +
                    "<td>" + jsonResponse[i].datumVanAanschafffing + "</td>" +
                    "<td>" + jsonResponse[i].bestemdVoor + "</td>" +
                    "<td>" + jsonResponse[i].prijs + "</td>" +

                    "</tr>";
            }
            document.getElementById("myCadeaus").innerHTML = html;// tabel zetten op plaats waar "myFriends" staat
            setTimeout(getMyCadeaus, 1500); // dit word herhaald elke 1.5 sec
        }
    }
}