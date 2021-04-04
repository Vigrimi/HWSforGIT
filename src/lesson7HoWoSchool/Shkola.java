package lesson7HoWoSchool;

import java.util.Arrays;

public class Shkola implements MetodUchit
{
    public final static String nameShkoly = "Shkola #1";
    public Uchitel[] arrArmyUchiteley;
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
    // внести чтоб работал интерфейс учитель учит ученика!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    /*public void uchitelUchitUchenika()
    {
        for (int i = 0; i < arrArmyUchiteley.length; i++)
        {
            int a = 0;
            System.out.println("Учитель " + arrArmyUchiteley[i]);
            for (int j = 0; j < arrArmyUchenikov.length; j++)
            {
                if(arrArmyUchiteley[i].izuchaemPredmet.equals(arrArmyUchenikov[j].izuchaemPredmet))
                {
                    System.out.println(" учит ученика " + arrArmyUchenikov[j]);
                    a++;
                } //else System.out.println(" никого ничему не учит :(");
            }
            if (a == 0) System.out.println(" никого ничему не учит :(");
        }
    }*/

    public void dayAtSchool()
    {
        System.out.println("\n1. На часах самое на то время и Директор школы " + direktor.name + " объявляет начало занятий!");
        System.out.println("2. Учителя учат учеников (предмет учителя и ученика должны совпадать): ");
        uchitelUchitUchenika(this.arrArmyUchiteley, this.arrArmyUchenikov); //MetodUchit() //.uchitelUchitUchenika();
        System.out.println("3. Вот и время прошло и Директор объявляет окончание занятий!))");
        //ученик уровень знаний
    }

    /*@Override
    public void uchitelUchitUchenika(lesson7HoWoSchool.Uchitel[] uchitels, Uchenik[] ucheniks) {

    }*/

    @Override
    public String toString() {
        return "->" + direktor + "\nСостоит из: " +
                "\nармии учителей: -" + Arrays.toString(arrArmyUchiteley) +
                ", \nармии учеников: " + '\u2708' + " " + Arrays.toString(arrArmyUchenikov) +
                '.';
    }
}
