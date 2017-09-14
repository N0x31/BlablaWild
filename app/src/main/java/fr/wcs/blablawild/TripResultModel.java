package fr.wcs.blablawild;

import java.util.Date;

public class TripResultModel {

    //pour déclarer les attributs
    private String surname;
    private int price;
    private Date date;

    // pour initialiser les attributs (Constructeur)
    public TripResultModel (String surname, Date date, int price)
    {
        this.surname = surname;
        this.price = price;
        this.date = date;
    }

    //pour récupérer les valeurs des attributs (Getters et setters)
    public String getSurname(){
        return this.surname;
    }
    public int getPrice(){
        return this.price;
    }

    public Date getDate(){
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}


