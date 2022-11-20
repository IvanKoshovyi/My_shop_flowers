package Flowers;

import java.time.LocalDate;

public class Rose extends Flowers {
    private int RoseCost;
    private LocalDate Fresh;

    public Rose(int idFlowers, int cost, LocalDate fresh, int stalkLength) {
        super(cost, fresh, stalkLength);
        Fresh = fresh;
        RoseCost = cost;
        setName_flowers("Троянда");
        setIdFlowers(idFlowers);
    }
}




