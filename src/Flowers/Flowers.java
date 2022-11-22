package Flowers;

import java.time.LocalDate;


public class Flowers{
    //Свойства
    private int Cost;
    int idFlowers;

    private String Name_flowers;
    private LocalDate Fresh;
    private int StalkLength;


    //Конструктор
    public Flowers(String Name, int IDFlowers, int cost, LocalDate fresh, int stalkLength) {
        Name_flowers = Name;
        idFlowers = IDFlowers;
        Cost = cost;
        Fresh = fresh;
        StalkLength = stalkLength;
    }
    public int getIdFlowers() {
        return idFlowers;
    }
    public String getName_flowers() {
        return Name_flowers;
    }

    public LocalDate getFresh() {
        return Fresh;
    }

    public int getCost() {
        return Cost;
    }

    public int getStalkLength() {
        return StalkLength;
    }

}

