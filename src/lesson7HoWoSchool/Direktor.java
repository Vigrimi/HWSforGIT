package lesson7HoWoSchool;

public class Direktor
{
    public String name;
    private int age;

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

    public /*static*/ String getName()
    {
        return name;
    }

    public void setName() //String name
    {
        name = "IVANOV";
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        age = 33;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Direktor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
