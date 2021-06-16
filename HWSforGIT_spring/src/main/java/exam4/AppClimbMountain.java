package exam4;

import java.util.UUID;

public class AppClimbMountain
{
    // com.ifmo.jjd
    // com.profi.jjd
    public static void main(String[] args)
    {

        Climber climber1 = new Climber();
        // обращение к свойствам объекта
//        climber1.fullName = "Ivan Grigoriev"; // присвоили имя
//        climber1.age = 20;
//        climber1.email = "ivan@cvb.com";
//        climber1.uuid = UUID.randomUUID();
        // вызов методов
        climber1.setFullName("Ivan Grigoriev"); //вызываем метод и в него сразу передаём значения,
        //если он готов принять значения - для этого в круглых скобках в Клаймбер должно быть указано
        //что принимать и какого типа
        climber1.setAge(34);
        climber1.setEmail("ivan@cvb.com");
        climber1.setUuid();


        Climber climber2 = new Climber();
        // обращение к свойствам объекта
//        climber2.fullName = "Elena Mikhaylova"; // присвоили имя
//        climber2.age = 21;
//        climber2.email = "elena@cvb.com";
//        climber2.uuid = UUID.randomUUID();
        climber2.setFullName("Elena Mikhaylova"); // так мы вводим данные и сразу проверяем их на валидность
        // по инструкциям в классе Climber
        climber2.setAge(25);
        climber2.setEmail("elena@cvb.com");
        climber2.setUuid();

        //получить значение свойства
        int elenaAge = climber2.getAge();

        System.out.println(climber1);
        System.out.println(climber2);

        Mountain everest = new Mountain("Everest", 8_000); //создали объект, создали экземпляр класса
        Mountain elbrus = new Mountain("Elbrus", 6_000); // вызов конструктора

        Mountain defaultMountain = new Mountain(); // см в классе Маунтейн стр 9

        System.out.println(everest);
        System.out.println(elbrus);

//        ClimbingGroup f = new ClimbingGroup(everest, 5);
//        System.out.println(f);

    }
}
