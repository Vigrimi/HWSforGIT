package exam4;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "exam4_tb_mountains")
@Getter
@Setter
public class Mountain
{
    @Id // первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // автоинкремент - значения увеличиваются на единицу
    private int id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private int height;

    public Mountain(String name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return "\nГора {" +
                "id= " + id +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
