package exam4.external;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@ConfigurationProperties(prefix = "thread.config")
@Getter
@Setter
public class ThreadConfig
{
    private int corePoolSize; // thread.config.corePoolSize=3 это стринг, но спринг сам переведёт в инт
    private int maxPoolSize;
    private String threadName;

    // создаём метод который будет возвращать объект типа TaskExecutor - пул потоков в спринге
    @Bean // метод public TaskExecutor threadPool() вызывается автоматически, метод вернёт объект типа данных
    // TaskExecutor и спринг сохранит его в контексте во внутренней мапе

    // @Primary - в процессе работы мэйна может быть создано несколько объектов и программа не поймёт какой надо
    // использовать, так как программе нужен только один объект. И тогда, если у объекта будет аннотация @Primary - то
    // программа будет брать именно этот объект.
    @Qualifier("threadPool") // или создаваемому бину @Bean задать имя
    public TaskExecutor threadPool()
    {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize); // сколько всего изначально потоков будет создано в пуле
        executor.setMaxPoolSize(maxPoolSize); // сколько будет создаваться если не справляется
        //executor.setKeepAliveSeconds(60); // сколько секунд поток будет живым если не выполняет задачу
        executor.setThreadNamePrefix(threadName); // задать имя для каждого потока - для отладки
        executor.initialize(); // создание и чтобы смогли работать

        return executor;
    }

}