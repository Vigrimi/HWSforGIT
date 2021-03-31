package Lesson6HoWoCats;

public class Cat
{
    // int a = (int) ((Math.random() * 7) + 1); // fm 1 to 7
    private String nameCat;
    private String colourCat;
    private int speedCat;
    private int weightCat;

    public String getNameCat()
    {
        return nameCat;
    }
    public void setNameCat()
    {
        String[] arrNameCats = new String[] {"ВАСЯ","КОЛЯ","ВАНЯ","ПЕТЯ","МАНЯ","ТОНЯ","КИСА","ГАВ","МЯУ","КИСЬ","БРЫСЬ"};
        int a = (int) (Math.random() * 11);
        this.nameCat = arrNameCats[a];
    }

    public String getColourCat()
    {
        return colourCat;
    }
    public void setColourCat()
    {
        String[] arrColourCat = new String[] {"КРАСНЫЙ","ОРАНЖЕВЫЙ","ЖЁЛТЫЙ","ЗЕЛЁНЫЙ","ГРАНАТОВЫЙ","СИНИЙ","ФИОЛЕТОВЫЙ","ПОШКАРЯБАННЫЙ"};
        int b = (int) (Math.random() * 8);
        this.colourCat = arrColourCat[b];
    }

    public int getSpeedCat()
    {
        return speedCat; // = s;
    }
    public void setSpeedCat()
    {
        int s = (int) (Math.random() * 100);
        this.speedCat = s;
    }

    public int getWeightCat()
    {
        return weightCat;
    }

    public void setWeightCat()
    {
        int w = (int) (Math.random() * 10);
        this.weightCat = w;
    }

    @Override
    public String toString() {
        return "Котейка: " +
                "по имени '" + nameCat + '\'' + "; цвет: " + colourCat + "; скорость: " + speedCat + " км/секунду" +
                "; весом: " + weightCat + "кг" + '.';
    }
}
