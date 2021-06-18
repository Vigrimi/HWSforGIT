package exam4;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "exam4_tb_climbers")
public class Climber
{
    @Getter
    @Setter
    @Id // первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // автоинкремент - значения увеличиваются на единицу
    private int id;

    @Getter
    @Setter
    @Column(name = "fullname",nullable = false,unique = true)
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

    @Override
    public String toString() {
        return "\nClimber{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", uuid=" + uuid +
                "}\n";
    }
}
