package lesson7HoWoSchool;

public class Uchenik extends Direktor // Uchitel
{
    public String izuchaemPredmet;
    private int urovenZnaniy;

    public Uchenik(String name, int age, String izuchaemPredmet) // обязательный конструктор иначе супер не работает
    {
        super(name,age); //,izuchaemPredmet); // из родителя берём - вызов конструктора родителя
        this.izuchaemPredmet = izuchaemPredmet;
        this.urovenZnaniy = urovenZnaniy;
    }

    public static Uchenik getUchenik()
    {
        Uchenik uchenik = new Uchenik(
                Randoms.getRandomName(),
                Randoms.getRandomAgeUchenik(),
                Randoms.getIzuchaemPredmet() // Uchitel.getUchitel().izuchaemPredmet //
        );
        return uchenik;
    }

    public void uchutsya() // метод: учиться() - уровень знаний ученика повышается
    {
        urovenZnaniy++;
    }

    @Override
    public String toString() {
        return "\n" +
                "имя '" + name + '\'' +
                ", возраст " + age +
                ", изучаемый предмет '" + izuchaemPredmet + '\'' +
                ' ';
    }
}
