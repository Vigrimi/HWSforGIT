package lesson7HoWoSchool;

public interface MetodUchit
{

    default void uchitelUchitUchenika(Uchitel[] uchitels, Uchenik[] ucheniks) //массив учител учителс сразу берёт
            //массив армия учителей и его не надо нигде присваивать
    {
//        public void teach(Shkola.arrArmyUchiteley, Shkola[] arrUchen)
//        {
//            //arrUchit =
//        }

//        arrUchit = new String[];
//        arrUchit = Shkola.
//
//        String[] uu = new String[];
//        uu = ;
        int a = 0;
        for (int i = 0; i < uchitels.length; i++)
        {
            System.out.println("Учитель " + uchitels[i]);
            for (int j = 0; j < ucheniks.length; j++)
            {
                if(uchitels[i].izuchaemPredmet.equals(ucheniks[j].izuchaemPredmet))
                {
                    System.out.println(" учит ученика " + ucheniks[j]);
                    a++;
                } //else System.out.println(" никого ничему не учит :(");
            }
            if (a == 0) System.out.println(" никого ничему не учит :(");
        }
    }
}
