package lesson7HoWoSchool;

public class Direktor
{
    public String name;
    public int age;

    public Direktor() //конструктор без параметров
    {
        setName();
        setAge();
    }
    public Direktor(String name, int age) // обязательный конструктор иначе супер не работает
    {
        this.name = name;
        this.age = age;
    }

    public void nachaloZanyatiy() //метод
    {
        System.out.println("НАЧАЛО ЗАНЯТИЙ!");
    }
    public void konetsZanyatiy()
    {
        System.out.println("ОКОНЧАНИЕ ЗАНЯТИЙ!");
    }

    //public static Direktor getName() //
    public String getName()
    {
        return name;
    }

    public void setName()     //public void Direktor setName() //String name
    {
        //name = "IVANOV";
        this.name = "IVANOV"; // name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge() //(int age)
    {
        //age = 33;
        this.age = 33;
    }

    @Override
    public String toString() {
        return "\nНаш директор школы: " +
                "имя '" + name + '\'' +
                ", возраст " + age +
                ';';
    }
}
