package lesson7HoWoSchool;

public class Uchitel extends Direktor
{
    public String izuchaemPredmet;

    public Uchitel(String name, int age, String izuchaemPredmet) // обязательный конструктор иначе супер не работает
    {
        super(name, age); // izuchaemPredmet);
        this.izuchaemPredmet = izuchaemPredmet;
    }

    public void uchit (Uchenik uchenik)
    {
        System.out.println("УЧИТЕЛЬ УЧИТ ОБУЧАЕМОГО " + uchenik);
    }



}
