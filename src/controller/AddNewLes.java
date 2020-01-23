package controller;

import domain.Les;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AddNewLes extends AsyncRequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //gegevens opvragen van de request in de url - aadNewLes.js
        String dateLes = request.getParameter("dateLes");
        String naamLes = request.getParameter("naamLes");
        String lenLes = request.getParameter("lenLes");

        System.out.println("Date: " + dateLes);
        System.out.println("Naam: " + naamLes);
        System.out.println("Length: " + lenLes);

        ArrayList<String> errors = new ArrayList<>();

        //na kijken of die les al bestaat
        for (Les l: getPersonService().getLessen()) {
            if(l.getNaamLes().equals(naamLes)){

                errors.add("les bestaat al");

            }
        }


        if(errors.size() > 0){
        } else {//nieuw les toevoen als die nog niet bestond
            Les les = new Les(dateLes,naamLes,lenLes);
            System.out.println("Les: " + les);
            getPersonService().addLes(les);
            System.out.println("Lessen: " + getPersonService().getLessen());
        }

        return null;
    }
}