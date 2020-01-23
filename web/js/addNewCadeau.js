var xHRObjectAddCadeau = new XMLHttpRequest();

//AddFriend
function addNewCadeau() {


    //Waardes van de input veldjes opslagen
    var omschrijving = document.getElementById("omschrijving").value;
    var datumVanAanschafffing = document.getElementById("datumVanAanschafffing").value;
    var bestemdVoor = document.getElementById("bestemdVoor").value;
    var prijs = document.getElementById("prijs").value;

    //Waardes naar controller sturen
    xHRObjectAddCadeau.open("POST", "Controller?action=AddNewCadeau&omschrijving="+omschrijving
        +"&datumVanAanschafffing="+datumVanAanschafffing
        +"&bestemdVoor="+bestemdVoor
        +"&prijs="+prijs, true);
    xHRObjectAddCadeau.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //Input veldjes leegmaken
    document.getElementById("omschrijving").value = "";
    document.getElementById("datumVanAanschafffing").value = "";
    document.getElementById("bestemdVoor").value = "";
    document.getElementById("prijs").value = "";

    //Waardes doorsturen naar response
    xHRObjectAddCadeau.send("omschrijving=" + omschrijving);
    xHRObjectAddCadeau.send("datumVanAanschafffing=" + datumVanAanschafffing);
    xHRObjectAddCadeau.send("bestemdVoor=" + bestemdVoor);
    xHRObjectAddCadeau.send("prijs=" + prijs);
}