var xHRObjectAddLes = new XMLHttpRequest();

//AddFriend
function addNewLes() {


    //Waardes van de input veldjes opslagen
    var dateLes = document.getElementById("dateLes").value;
    var naamLes = document.getElementById("naamLes").value;
    var lenLes = document.getElementById("lenLes").value;

    //Waardes naar controller sturen
    xHRObjectAddLes.open("POST", "Controller?action=AddNewLes&dateLes="+dateLes+"&naamLes="+naamLes+"&lenLes="+lenLes, true);
    xHRObjectAddLes.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //Input veldjes leegmaken
    document.getElementById("dateLes").value = "";
    document.getElementById("naamLes").value = "";
    document.getElementById("lenLes").value = "";

    //Waardes doorsturen naar response
    xHRObjectAddLes.send("dateLes=" + dateLes);
    xHRObjectAddLes.send("naamLes=" + naamLes);
    xHRObjectAddLes.send("lenLes=" + lenLes);
}