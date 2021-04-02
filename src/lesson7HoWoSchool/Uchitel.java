package lesson7HoWoSchool;

public class Uchitel extends Direktor
{
    public String izuchaemPredmet;

    public Uchitel(String name, int age, String izuchaemPredmet) // обязательный конструктор иначе супер не работает
    {
        super(name, age); // izuchaemPredmet);
        this.izuchaemPredmet = izuchaemPredmet;
    }

    public static Uchitel getUchitel() //public Uchitel()
    {
        Uchitel uchitel = new Uchitel(
                Randoms.getRandomName(),
                Randoms.getRandomAge(),
                Randoms.getIzuchaemPredmet()
        );
        return uchitel;
    }

//    public void uchit (Uchenik uchenik)
//    {
//        System.out.println("УЧИТЕЛЬ УЧИТ ОБУЧАЕМОГО " + uchenik);
//    }

    public String getIzuchaemPredmet()
    {
        return izuchaemPredmet;
    }

    public void setIzuchaemPredmet()
    {
       // izuchaemPredmet = getUchitel().getIzuchaemPredmet();
        this.izuchaemPredmet = getUchitel().getIzuchaemPredmet(); // = Randoms.getIzuchaemPredmet();
    }

    @Override
    public String toString() {
        return "" +
                "\nимя '" + name + '\'' +
                ", возраст " + age +
                ", предмет '" + izuchaemPredmet + '\'' +
                ' ';
    }
}
