package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Les {
    private String dateLes,naamLes, lenLes;
    @JsonIgnore
    private ArrayList<Les> myLessen;


    public Les(String dateLes, String naamLes, String lenLes) {
        setDateLes(dateLes);
        setNaamLes(naamLes);
        setLenLes(lenLes);
        myLessen = new ArrayList<>();
    }

    public Les() {
    }
//getters
    public String getDateLes() {
        return dateLes;
    }

    public String getNaamLes() {
        return naamLes;
    }

    public String getLenLes() {
        return lenLes;
    }

    public ArrayList<Les> getMyLessen() {
        return myLessen;
    }
    //setters


    public void setDateLes(String dateLes) {
        this.dateLes = dateLes;
    }

    public void setNaamLes(String naamLes) {
        this.naamLes = naamLes;
    }

    public void setLenLes(String lenLes) {
        this.lenLes = lenLes;
    }

//lessen
    public void addLes(Les l){
        this.myLessen.add(l);
    }
}
