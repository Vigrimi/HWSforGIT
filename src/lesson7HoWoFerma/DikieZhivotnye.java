package lesson7HoWoFerma;

public class DikieZhivotnye extends AbstrClassZhivotnye
{
    public int silaDikieZhivotnye;
    public static DikieZhivotnye[] arrDikieZhivotnyes; //имя, вес, скорость, сила

    public DikieZhivotnye(String tipZhivotnogo, int vesZhivotnogo, int skorostZhivotnogo, int silaDikieZhivotnye)
    {
        super(tipZhivotnogo, vesZhivotnogo, skorostZhivotnogo);
        this.silaDikieZhivotnye = silaDikieZhivotnye;
    }

    public static DikieZhivotnye[] getDikieZhivotnye() //Дикие животные: Волк, Медведь, Лисица.
    {
        String[] dikieZhiv = new String[]{"Волк", "Медведь", "Лисица"};
        arrDikieZhivotnyes = new DikieZhivotnye[dikieZhiv.length];
        for (int i = 0; i < dikieZhiv.length; i++)
        {
            //int sedobnost = 1; // 0 = несъедобное
            //if (i == 1) sedobnost = 0;
            int vess = RandomsFerma.getRandomFm1To11();
            //if (i == 0) skorost = (RandomsFerma.getRandomFm1To11() * 9);
            DikieZhivotnye korova1 = new DikieZhivotnye(dikieZhiv[i], vess, RandomsFerma.getRandomFm1To11(), RandomsFerma.getRandomFm1To11() );
            arrDikieZhivotnyes[i] = korova1;
        }
        return arrDikieZhivotnyes;
    }



    @Override
    public String toString() {
        return "DikieZhivotnye{" +
                "tipZhivotnogo='" + tipZhivotnogo + '\'' +
                ", vesZhivotnogo=" + vesZhivotnogo +
                ", skorostZhivotnogo=" + skorostZhivotnogo +
                ", silaDikieZhivotnye=" + silaDikieZhivotnye +
                '}';
    }
}
