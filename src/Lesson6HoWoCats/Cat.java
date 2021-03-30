package Lesson6HoWoCats;

public class Cat
{
    // int a = (int) ((Math.random() * 7) + 1); // fm 1 to 7
    private String nameCat;
    private String colourCat;
    private int speedCat;
    private int weightCat;
    private int qtyCatchedMouses;

    public String getNameCat()
    {
        String[] arrNameCats = new String[] {"ВАСЯ","КОЛЯ","ВАНЯ","ПЕТЯ","МАНЯ","ТОНЯ","КИСА","ГАВ","МЯУ","КИСЬ","БРЫСЬ"};
        int a = (int) (Math.random() * 11);
        return nameCat = arrNameCats[a];
    }

    public String getColourCat()
    {
        String[] arrColourCat = new String[] {"КРАСНЫЙ","ОРАНЖЕВЫЙ","ЖЁЛТЫЙ","ЗЕЛЁНЫЙ","ГРАНАТОВЫЙ","СИНИЙ","ФИОЛЕТОВЫЙ","ПОШКАРЯБАННЫЙ"};
        int b = (int) (Math.random() * 8);
        return colourCat = arrColourCat[b];
    }

    public int getSpeedCat()
    {
        int s = (int) (Math.random() * 100);
        return speedCat = s;
    }

    @Override
    public String toString() {
        return "Котейка: " +
                "по имени '" + nameCat + '\'' + "; цвет: " + colourCat + "; скорость: " + speedCat + " км/секунду " +
                '.';
    }
}
