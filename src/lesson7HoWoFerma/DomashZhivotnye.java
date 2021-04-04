package lesson7HoWoFerma;

import java.util.Arrays;

public class DomashZhivotnye extends AbstrClassZhivotnye
{
    public int zdorovyeZhivotnogo;
    public int flagSyedobnoeZhivotnoe; // флаг (пригодно в пищу = 1 или нет = 0),
    protected int resursZhivotnogo; //количество ресурсов (у каждого свое и 0, если животное не дает ресурс).
    public static DomashZhivotnye[] arrDomashZhivotnyes;

    public DomashZhivotnye(String tipZhivotnogo, int vesZhivotnogo, int skorostZhivotnogo, int zdorovyeZhivotnogo, int flagSyedobnoeZhivotnoe, int resursZhivotnogo)
    {
        super(tipZhivotnogo, vesZhivotnogo, skorostZhivotnogo);
        this.zdorovyeZhivotnogo = zdorovyeZhivotnogo;
        this.flagSyedobnoeZhivotnoe = flagSyedobnoeZhivotnoe;
        this.resursZhivotnogo = resursZhivotnogo;
    }

    public static DomashZhivotnye[] getDomashZhivotnye() //Домашние животные: Корова, Кот, Курица, Кролик
    {
        String[] domashZhiv = new String[]{"Корова", "Кот", "Курица", "Кролик"};
        arrDomashZhivotnyes = new DomashZhivotnye[domashZhiv.length];
        for (int i = 0; i < domashZhiv.length; i++)
        {
            int sedobnost = 1; // 0 = несъедобное
            if (i == 1) sedobnost = 0;
            int vess = RandomsFerma.getRandomFm1To11();
            if (i == 0) vess = (RandomsFerma.getRandomFm1To11() * 9);
        DomashZhivotnye korova = new DomashZhivotnye(domashZhiv[i],
                vess,
                RandomsFerma.getRandomFm1To11()/*skorostZhivotnogo*/,
                getZdorovyeZhivotnogo()/*zdorovyeZhivotnogo*/,
                sedobnost, RandomsFerma.getRandomFm1To11()/*resursZhivotnogo*/);
            arrDomashZhivotnyes[i] = korova;
        }
        return arrDomashZhivotnyes;
    }

    public static int getZdorovyeZhivotnogo() {
        return RandomsFerma.getRandomFm1To11();
    }

    /*public void setZdorovyeZhivotnogo(int zdorovyeZhivotnogo)
    {
        this.zdorovyeZhivotnogo = RandomsFerma.getRandomFm1To11();
    }*/

    @Override
    public String toString()
    {
        return  "\nДомашнее животное: '" + tipZhivotnogo + '\'' +
                ", весом (кг) " + vesZhivotnogo +
                ", со скоростью " + skorostZhivotnogo +
                ", уровнем здоровья " + zdorovyeZhivotnogo +
                ", " + ((flagSyedobnoeZhivotnoe == 0) ? "несъедобное" : "съедобное") +
                ", ресурс животоного " + resursZhivotnogo +
                ' ';
    }
}
