package Flowers;

import java.time.LocalDate;

public class Tulip extends Flowers{
    private static final String name = "Тюльпан";

    public Tulip(int idFlowers,int cost, LocalDate fresh, int stalkLength) {
        super(name, idFlowers, cost, fresh, stalkLength);
    }

}
