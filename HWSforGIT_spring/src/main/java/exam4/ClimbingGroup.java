package exam4;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exam4_tb_climbing_groups")
@Getter
public class ClimbingGroup
{
    @Setter
    @Id // первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // автоинкремент - значения увеличиваются на единицу
    private int id;

    @Column(name = "mountain_name_height",nullable = false,length = 1000)
    private String mountainNameHeight;

    @Column(name = "climbing_group",nullable = false,length = 100000)
    private String climbingGroup;

    @Column(name = "start_climbing",nullable = false)
    private LocalDateTime startClimbing; // свойство start (дата и время восхождения на гору)

    public ClimbingGroup(String mountainNameHeight, String climbingGroup, LocalDateTime startClimbing) {
        this.mountainNameHeight = mountainNameHeight;
        this.climbingGroup = climbingGroup;
        this.startClimbing = startClimbing;
    }
    public ClimbingGroup(){}

    public void setMountainNameHeight(Mountain mountain)
    {
        this.mountainNameHeight = mountain.getName() + ", " + mountain.getHeight();
    }

    public void setClimbingGroup(Climber[] climbers)
    {
        String s = "";
        for (int i = 0; i < climbers.length; i++)
        {
            s = s + climbers[i].getFullName() + ", " + climbers[i].getAge() + ", " + climbers[i].getEmail()
                    + ", " + climbers[i].getUuid() + "; \n";
        }
        this.climbingGroup = s;
    }

    public void setStartClimbing(long a)
    {
        if(a <= 3)
        {
            this.startClimbing = LocalDateTime.now().minusMonths(a).minusDays(a).minusHours(a);
        } else
        {
            this.startClimbing = LocalDateTime.now().plusMonths(a).plusDays(a).plusHours(a);
        }

    }

    @Override
    public String toString() {
        return "\nClimbingGroup{" +
                "id= " + id +
                ", mountain=" + mountainNameHeight +
                ", \nclimbers=" + climbingGroup +
                ", \nLocalDateTime startClimbing= " + startClimbing +
                "}\n";
    }
}
