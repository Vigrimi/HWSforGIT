package exam4.external;

import exam4.Climber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.UUID;

@Component
// чтобы не создавать объекты вручную - но спринг создаст только один объект и возвращает ссылку только на него
@Scope("prototype") // а чтобы создавалось столько объектов сколько нужно - при каждом вызове метода getBean создаётся
// новый объект
public class ClimberParser implements Runnable
{
    private EntityManager manager; // ссылка на менеджер сущности
    private ClimberRepository repository; // если нужен доступ к репозиторию

    public ClimberParser(){}

    @Autowired
    public ClimberParser(ClimberRepository repository, EntityManager manager) {
        this.repository = repository;
        this.manager = manager;
    }

    @Override
    public void run()
    {
            //CourseParser courseParser = context.getBean(CourseParser.class); // создаём ранэбл объект потока
        Climber climber1 = new Climber("climber1",21,"climber1@email.com", UUID.randomUUID());

        manager.getTransaction().begin();
        manager.persist(climber1);
        manager.getTransaction().commit();

        //repository.save(climber1);
    }
}
