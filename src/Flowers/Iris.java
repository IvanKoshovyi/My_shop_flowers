package Flowers;

import java.time.LocalDate;

public class Iris extends Flowers {
    private static final String name = "Ірис";
    public Iris(int idFlowers,int cost, LocalDate fresh, int stalkLength) {
        super(name, idFlowers, cost, fresh, stalkLength);
    }
}
