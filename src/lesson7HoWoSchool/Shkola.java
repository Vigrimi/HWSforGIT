package lesson7HoWoSchool;

import java.util.Arrays;

public class Shkola
{
    public final static String nameShkoly = "Shkola #1";
    private Uchitel[] arrArmyUchiteley;
    private Uchenik[] arrArmyUchenikov;

    //Direktor direktor = new Direktor(Direktor.getName(), Direktor.getAge());


    public void generateArrArmyUchiteley()
    {
        arrArmyUchiteley = new Uchitel[5];
        for (int i = 0; i < arrArmyUchiteley.length; i++)
        {
            //arrArmyUchiteley[i] = Uchitel.
        }
    }

    @Override
    public String toString() {
        return "Shkola{" +
                "arrArmyUchiteley=" + Arrays.toString(arrArmyUchiteley) +
                ", arrArmyUchenikov=" + Arrays.toString(arrArmyUchenikov) +
               // ", direktor=" + direktor +
                '}';
    }
}
