package exam4.external;

import exam4.Climber;
import org.springframework.data.repository.PagingAndSortingRepository;

// собрать, получить, изменить, удалить инфу из таблиц
public interface ClimberRepository extends PagingAndSortingRepository<Climber,Integer>
{

}
