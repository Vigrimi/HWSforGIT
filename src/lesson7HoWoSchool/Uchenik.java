package lesson7HoWoSchool;

public class Uchenik extends Uchitel
{
    //private String izuchaemPredmet;
    private int urovenZnaniy;

    public Uchenik(String name, int age, String izuchaemPredmet) // обязательный конструктор иначе супер не работает
    {
        super(name,age,izuchaemPredmet); // из родителя берём - вызов конструктора родителя
        this.urovenZnaniy = urovenZnaniy;
    }

    public void uchutsya() // метод: учиться() - уровень знаний ученика повышается
    {
        urovenZnaniy++;
    }



}
