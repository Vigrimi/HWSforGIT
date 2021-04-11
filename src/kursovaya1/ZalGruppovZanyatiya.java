package kursovaya1;

public class ZalGruppovZanyatiya
{
    public static int maxQtyLyudeyGruppZanyatiya = 20;
    public int gdeNahoditsyaAbonent;
    public static int seichasVZalGruppovZanyatiya;

    public ZalGruppovZanyatiya(int gdeNahoditsyaAbonent) {
        maxQtyLyudeyGruppZanyatiya = 20;
        this.gdeNahoditsyaAbonent = gdeNahoditsyaAbonent;
    }
    public static int getSeichasVZalGruppovZanyatiya() {
        seichasVZalGruppovZanyatiya++;
        return seichasVZalGruppovZanyatiya;
    }
    public static int getMaxQtyLyudeyGruppZanyatiya() {
        return maxQtyLyudeyGruppZanyatiya;
    }
}
