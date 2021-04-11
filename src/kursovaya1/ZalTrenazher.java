package kursovaya1;

public class ZalTrenazher
{
    public static int maxQtyLyudeyTrenazher = 20;
    public int gdeNahoditsyaAbonent;
    public static int seichasVZalTrenazher;

    public ZalTrenazher() {
        maxQtyLyudeyTrenazher = 20;
        this.gdeNahoditsyaAbonent = 2;
    }
    public static int getSeichasVZalTrenazher() {
        seichasVZalTrenazher++;
        return seichasVZalTrenazher;
    }
    public static int getMaxQtyLyudeyTrenazher() {
        return maxQtyLyudeyTrenazher;
    }
}
