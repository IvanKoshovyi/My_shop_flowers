package Flowers;

import java.time.LocalDate;

public class Iris extends Flowers {
    private int IrisCost;
    private LocalDate Fresh;
    public Iris(int idFlowers,int cost, LocalDate fresh, int stalkLength) {
        super(cost,fresh, stalkLength);
        Fresh = fresh;
        IrisCost = cost;
        setName_flowers("Ірис");
        setIdFlowers(idFlowers);
    }
}
