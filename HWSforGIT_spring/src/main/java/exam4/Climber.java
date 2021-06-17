package exam4;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_climbers_exam4")
public class Climber
{
    @Id // первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // автоинкремент - значения увеличиваются на единицу
    private int id;

    //свойства их называют иногда поля или атрибуты
    @Getter
    @Setter
    @Column(nullable = false)
    private String fullName;

    @Getter
    @Setter
    @Column(nullable = false)
    private int age;

    @Getter
    @Setter
    @Column(nullable = false)
    private String email;

    @Getter
    @Setter
    @Column(nullable = false)
    private UUID uuid; // уникальный айди,генерирует уник-е айди

    public Climber() {}

    public Climber(String fullName, int age, String email, UUID uuid) {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.uuid = uuid;
    }

    /*public void setUuid() {
        this.uuid = UUID.randomUUID();
    }*/

 /*   //методы проверки на валидность вводимых данных - грубо говоря инструкции
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
    }*/

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
