package sia.taco_cloud.dao;

import org.springframework.data.repository.CrudRepository;
import sia.taco_cloud.order.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
}
