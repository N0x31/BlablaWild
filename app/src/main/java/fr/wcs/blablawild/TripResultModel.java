package fr.wcs.blablawild;


import java.util.Date;

public class TripResultModel {

//pour déclarer les attributs
    private String surname;
    private int price;
    private Date date;

    // pour instancier les attributs
    public TripResultModel (String surname, Date date, int price)
    {
        this.surname = surname;
        this.price = price;
        this.date = date;
    }

    //pour récupérer les valeurs des attributs
    public String getSurname() {
        return surname;
    }
    public int getPrice(){
        return price;
    }
    public Date getDate(){
        return date;
    }

}


