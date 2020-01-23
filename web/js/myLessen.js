var xHRObjectMyLessen = new XMLHttpRequest();//xhttp request object

//GetMyFriends
function getMyLessen() {
    xHRObjectMyLessen.open("GET", "Controller?action=GetMyLessen", true);
    xHRObjectMyLessen.onreadystatechange = getData;
    xHRObjectMyLessen.send(null);
}

function getData() {

    if (xHRObjectMyLessen.readyState === 4) {
        if (xHRObjectMyLessen.status === 200 || xHRObjectMyLessen.status === 500) {
            var jsonResponse = JSON.parse(xHRObjectMyLessen.responseText); //respons casten naar json

            /*
            vriendenlijst tabel maken in html
             */
            var html = "";
            for (var i = 0; i < jsonResponse.length; i++) {

                console.log("JSON: " + jsonResponse);
                html += "<tr>" +
                    "<td>" + jsonResponse[i].dateLes + "</td>" +
                    "<td>" + jsonResponse[i].naamLes + "</td>" +
                    "<td>" + jsonResponse[i].lenLes + "</td>" +

                    "</tr>";
            }
            document.getElementById("myLessen").innerHTML = html;// tabel zetten op plaats waar "myFriends" staat
            setTimeout(getMyLessen, 1500); // dit word herhaald elke 1.5 sec
        }
    }
}