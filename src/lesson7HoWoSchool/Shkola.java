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
            arrArmyUchiteley[i] = new Uchitel("gsfhgf",125,"ytrewq");
        }
    }

    @Override
    public String toString() {
        return "Shkola{" +
                "\narrArmyUchiteley=" + Arrays.toString(arrArmyUchiteley) +
                ", \narrArmyUchenikov=" + Arrays.toString(arrArmyUchenikov) +
                ", \n->" + direktor +
                '.';
    }
}
