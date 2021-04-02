package lesson7HoWoSchool;

import java.util.Arrays;

public class Shkola
{
    public final static String nameShkoly = "Shkola #1";
    private Uchitel[] arrArmyUchiteley;
    private Uchenik[] arrArmyUchenikov;

    private Direktor direktor; //свойство
    public Shkola(Direktor direktor) // конструктор к свойству
    {
        this.direktor = direktor;
    }

    public void generateArrArmyUchiteley()
    {
        arrArmyUchiteley = new Uchitel[5];
        for (int i = 0; i < arrArmyUchiteley.length; i++)
        {
            //Uchitel uchitel = new Uchitel();
            arrArmyUchiteley[i] = Uchitel.getUchitel(); //uchitel; // new Uchitel("gsfhgf",125,"ytrewq");
        }
    }
    public void generateArrArmyUchenikov()
    {
        arrArmyUchenikov = new Uchenik[5];
        for (int j = 0; j < arrArmyUchenikov.length; j++)
        {
            //Uchitel uchitel = new Uchitel();
            arrArmyUchenikov[j] = Uchenik.getUchenik(); //uchitel; // new Uchitel("gsfhgf",125,"ytrewq");
        }
    }

    @Override
    public String toString() {
        return "->" + direktor + "\nСостоит из: " +
                "\nармии учителей: -" + Arrays.toString(arrArmyUchiteley) +
                ", \nармии учеников: " + '\u2708' + " " + Arrays.toString(arrArmyUchenikov) +
                '.';
    }
}
