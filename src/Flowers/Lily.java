package Flowers;

import java.time.LocalDate;

public class Lily extends Flowers {
    private int LilyCost;
    private LocalDate Fresh;

    public Lily(int idFlowers,int cost, LocalDate fresh, int stalkLength) {
        super(cost,fresh, stalkLength);
        Fresh = fresh;
        LilyCost = cost;
        setName_flowers("Лілія");
        setIdFlowers(idFlowers);
    }

}
