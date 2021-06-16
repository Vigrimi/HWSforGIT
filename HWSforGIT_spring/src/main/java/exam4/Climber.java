package exam4;

import java.util.Objects;
import java.util.UUID;

public class Climber
{
    //свойства их называют иногда поля или атрибуты
    private String fullName;
    private int age;
    private String email;
    private UUID uuid; // уникальный айди,генерирует уник-е айди

    //методы проверки на валидность вводимых данных - грубо говоря инструкции
    void setFullName(String fullName) // это метод устанавливающий свойства - также наз-ся "сеттер"
    {
        if (fullName == null || fullName.length() < 3) throw new IllegalArgumentException("значение name < 3");
        this.fullName = fullName;
    }

    void setAge(int age) // package-private
    {
        if (age < 18) throw new IllegalArgumentException("значение возраст < 18"); // throw исключение эксепшн
        this.age = age; // this это ссылка на age, который вверху на строке 9 и ему присвоить текущее значение age из main
    }

    public void setEmail(String email) {
        if (email == null || !email.trim().contains("@")) // trim просто убрали пробелы
        {
            throw new IllegalArgumentException("это не емэйл");
        }
        this.email = email;
    }

    public void setUuid() {
        this.uuid = UUID.randomUUID();
    }

    // получение - возврат свойств в мэйн
    public String getFullName() // возвращаем Стринг
    {
        return fullName;
    }

    public int getAge() // геттеры
    {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override // переопр клон // не доделал - надо сделать
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // переопр иквэлз
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Climber)) return false;
        Climber climber = (Climber) o;
        return age == climber.age && Objects.equals(fullName, climber.fullName) && Objects.equals(email, climber.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, age, email);
    }

    @Override
    public String toString() {
        return "Climber{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", uuid=" + uuid +
                '}';
    }
}
