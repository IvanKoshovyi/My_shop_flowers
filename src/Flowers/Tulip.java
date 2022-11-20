package Flowers;

import java.time.LocalDate;

public class Tulip extends Flowers{
    private int TulipCost;
    private LocalDate Fresh;

    public Tulip(int idFlowers,int cost, LocalDate fresh, int stalkLength) {
        super(cost,fresh, stalkLength);
        Fresh = fresh;
        TulipCost = cost;
        setName_flowers("Тюльпан");
        setIdFlowers(idFlowers);
    }

}
