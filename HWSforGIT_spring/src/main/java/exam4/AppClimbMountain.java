package exam4;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.persistence.*;

@SpringBootApplication
public class AppClimbMountain
{
    public static void main(String[] args)
    {
                //SpringApplication.run(AppClimbMountain.class, args);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpalesson");
        EntityManager manager = factory.createEntityManager();

        OperationsWithTables operationsWithTables = new OperationsWithTables(manager);
        operationsWithTables.insertIntoTables(); // наполняем три таблицы

        String exercise2_1 = "2. составить запросы для получения: 2.1 всех гор";
        operationsWithTables.getAllMountains(exercise2_1);

        String exercise2_2 = "2. составить запросы для получения: 2.2 гор с высотой от min(3_000) до max(7_000): ";
        operationsWithTables.getMountainsBtwnHeight(exercise2_2,3_000,7_000);

        String exercise2_3 = "2. составить запросы для получения: 2.3 групп, которые еще не начали восхождения на " +
                "горы относительно текущей даты: ";
        operationsWithTables.getClimbingGroupNotYetGoingUp(exercise2_3);

        String exercise2_4 = "2. составить запросы для получения: 2.4 альпиниста по имени (climber3) " +
                "и email(climber3@email.com): ";
        operationsWithTables.getClimberByNameEmail(exercise2_4,"climber3","climber3@email.com");

        String exercise2_5 = "2. составить запросы для получения: 2.5 гору по названию(mountain4): ";
        operationsWithTables.getMountainByName(exercise2_5,"mountain4");

        System.out.println("...-=ok=-...");

    }
}
