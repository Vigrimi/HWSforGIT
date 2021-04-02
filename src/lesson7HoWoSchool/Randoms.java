package lesson7HoWoSchool;

public class Randoms
{
    public static String getRandomName() //метод возвращает рандомное имя
    {
        String[] names = {"ВАНЯ","ПЕТЯ","КОЛЯ","МАША","ТАНЯ"};
        return names [(int) (Math.random() * names.length)];
    }
    public static int getRandomAge()
    {
        int age = (int) (Math.random() * 81 + 18);
        return age;
    }
    public static String getIzuchaemPredmet()
    {
        String[] izuchaemPredmet1 = {"ФИЗИКА","ХИМИЯ","РУС.ЯЗ.","МАТЕША","АНГЛ.ЯЗ."};
        return izuchaemPredmet1 [(int) (Math.random() * izuchaemPredmet1.length)];
    }
}
