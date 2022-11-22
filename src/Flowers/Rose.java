package Flowers;

import java.time.LocalDate;

public class Rose extends Flowers {
    private static final String name = "Троянда";
    public Rose(int idFlowers, int cost, LocalDate fresh, int stalkLength) {
        super(name, idFlowers, cost, fresh, stalkLength);
    }
}




