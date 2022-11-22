package Flowers;

import java.time.LocalDate;

public class Lily extends Flowers {
    private static final String name = "Лілія";

    public Lily(int idFlowers,int cost, LocalDate fresh, int stalkLength) {
        super(name, idFlowers, cost, fresh, stalkLength);
    }

}
