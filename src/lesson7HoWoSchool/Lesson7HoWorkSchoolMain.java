package lesson7HoWoSchool;

public class Lesson7HoWorkSchoolMain
{
    public static void main(String[] args)
    {
        System.out.println("Наша школа: " + Shkola.nameShkoly);
        Direktor direktor = new Direktor();// (Direktor.getName(), 8);

        Shkola shkola = new Shkola(direktor);
        shkola.generateArrArmyUchiteley();
        shkola.generateArrArmyUchenikov();
        System.out.println(shkola);
        shkola.dayAtSchool();
        //System.out.println(direktor);

    }
}
