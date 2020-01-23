package controller;

import domain.Les;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetMyLessen extends AsyncRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //lessenlijst halen

        List<Les> myLessen = getPersonService().getLessen();


        //json klaarmaken
        response.setContentType("application/json");//content type
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");//header + url
        response.getWriter().write(toJSON(myLessen)); // polling - server stuurt een json vriendenlijst mee in de response

        return null;
    }
}

