package lesson16HoWoPupils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.UUID;

public class Pupil
{
    public enum Gender
    {
        MALE, FEMALE
    }
    private UUID number; // уникальное значение для каждого ученика
    private String name;
    private Gender gender;
    private LocalDate birth;

    // TODO: добавить все необходимые методы
    public Pupil(){}
    public Pupil(UUID number, String name, Gender gender, LocalDate birth)
    {
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
    }

    public  UUID getNumber() {
        return number;
    }

    public void setNumber(UUID number) {
        this.number = number;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;     }

    public  Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "\nPupil{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}';
    }

    //функц интерфейс
    //@FunctionalInterface
    public static Pupil getInstance()
    {
        String[] arrNames = {"Алан","Александр","Алексей","Альберт","Альфред","Анатолий","Бернар","Богдан","Боголюб",
                "Болеслав","Бонифаций","Борис","Борислав","Варвара","Василиса","Венера","Вера","Вероника","Веселина",
                "Веста","Велизар","Венедикт","Вениамин","Виктор","Вилен","Вилли","Вильгельм","Виссарион","Галина",
                "Гаянэ","Гелена","Гелла","Генриетта","Геннадий","Генрих","Георгий","Геральд","Герасим","Герман",
                "Глеб","Ева","Евгения","Евдокия","Денис","Джордан","Дмитрий","Дональд","Донат","Светлана","Северина",
                "Серафима","Игорь","Измаил","Иван","Илиан","Илларион"};
        int len = arrNames.length;
        Random random = new Random();
        String name = arrNames[random.nextInt(len)];
        LocalDate birth = LocalDate.now();
        birth = birth.minusYears(17);
        birth = birth.plusDays(random.nextInt(28)).plusMonths(random.nextInt(8))
                .plusYears(random.nextInt(9)) ;
        return new Pupil
                (  UUID.randomUUID(),
                        name,
                ((name.endsWith("а") || name.endsWith("э") || name.endsWith("я")) ? Gender.FEMALE : Gender.MALE),
                        birth
                );
    }
    public Long getMonthsBetween()
    {
        LocalDate atNow = LocalDate.now();
        long between = Math.abs(ChronoUnit.MONTHS.between(atNow,getBirth())); // Pupil.getInstance().getBirth()));
        return between;
    }

}