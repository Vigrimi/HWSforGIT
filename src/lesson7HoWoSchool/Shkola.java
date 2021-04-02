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
    // Direktor direktor = new Direktor("QWERTY", 123); //(Direktor.getName(name), Direktor.getAge());
    //direktor.


    public void generateArrArmyUchiteley()
    {
        arrArmyUchiteley = new Uchitel[5];
        for (int i = 0; i < arrArmyUchiteley.length; i++)
        {
            //Uchitel uchitel = new Uchitel();
            arrArmyUchiteley[i] = Uchitel.getUchitel(); //uchitel; // new Uchitel("gsfhgf",125,"ytrewq");
        }
    }

    @Override
    public String toString() {
        return "\n->" + direktor + "\nСостоит из: " +
                "\nармии учителей: -" + Arrays.toString(arrArmyUchiteley) +
                ", \nармии учеников: " + Arrays.toString(arrArmyUchenikov) +
                '.';
    }
}
