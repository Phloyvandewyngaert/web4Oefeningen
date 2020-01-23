package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Cadeau {
    private String omschrijving, datumVanAanschafffing, bestemdVoor;
    private double prijs;
    @JsonIgnore
    private ArrayList<Cadeau> myCadeaus;

    public Cadeau(String omschrijving, String datumVanAanschafffing, String bestemdVoor, double prijs) {
        setOmschrijving(omschrijving);
        setDatumVanAanschafffing(datumVanAanschafffing);
        setBestemdVoor(bestemdVoor);
       setPrijs(prijs);
        this.myCadeaus = myCadeaus;
    }

    public Cadeau(String omschrijving, String datumVanAanschafffing, String bestemdVoor, String prijs) {
        setOmschrijving(omschrijving);
        setDatumVanAanschafffing(datumVanAanschafffing);
        setBestemdVoor(bestemdVoor);
        setPrijs(prijs);
        this.myCadeaus = myCadeaus;
    }

    public Cadeau() {
    }

    //getters

    public String getOmschrijving() {
        return omschrijving;
    }

    public String getDatumVanAanschafffing() {
        return datumVanAanschafffing;
    }

    public String getBestemdVoor() {
        return bestemdVoor;
    }

    public double getPrijs() {
        return prijs;
    }

    public ArrayList<Cadeau> getMyCadeaus() {
        return myCadeaus;
    }

    //setters

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public void setDatumVanAanschafffing(String datumVanAanschafffing) {
        this.datumVanAanschafffing = datumVanAanschafffing;
    }

    public void setBestemdVoor(String bestemdVoor) {
        this.bestemdVoor = bestemdVoor;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public void setPrijs(String prijs) {
        this.prijs = Double.parseDouble(prijs);
    }
//cadeau
    public void addCadeaus(Cadeau cadeau) {
        this.myCadeaus.add(cadeau);
    }
}
