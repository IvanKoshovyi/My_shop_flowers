package Flowers;

import java.time.LocalDate;
import java.util.Objects;

public class Flowers{
    //Свойства
    private int Cost;
    int idFlowers;

    private String Name_flowers;
    private LocalDate Fresh;
    private int StalkLength;


    //Конструктор
    public Flowers(int cost, LocalDate fresh, int stalkLength) {
        Fresh = fresh;
        StalkLength = stalkLength;
        Cost = cost;
        Name_flowers = "";
    }

    public int getIdFlowers() {
        return idFlowers;
    }

    public void setIdFlowers(int idFlowers) {
        this.idFlowers = idFlowers;
    }

    public void setName_flowers(String name) {
        Name_flowers = name;
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

    public void setCost(int cost) {
        Cost = cost;
    }
}

