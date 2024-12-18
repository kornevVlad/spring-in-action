package sia.taco_cloud.dao;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import sia.taco_cloud.model.Taco;

import java.util.List;

public interface TacoRepository extends CrudRepository<Taco, Long> {
    List<Taco> findAll(PageRequest pageRequest);
}
