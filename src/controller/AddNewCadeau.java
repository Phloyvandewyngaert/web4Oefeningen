package controller;

import domain.Cadeau;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddNewCadeau extends AsyncRequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       //gegevens opvragen van de request in de url - aadNewFriends.js
        String omschrijving = request.getParameter("omschrijving");
        String datumVanAanschafffing = request.getParameter("datumVanAanschafffing");
        String bestemdVoor = request.getParameter("bestemdVoor");
        String prijs = request.getParameter("prijs");


        Cadeau c = new Cadeau(omschrijving,datumVanAanschafffing,bestemdVoor,prijs);


        getPersonService().addCadeau(c);

        return null;
    }
}
