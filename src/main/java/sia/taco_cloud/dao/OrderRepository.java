package sia.taco_cloud.dao;


import org.springframework.data.repository.CrudRepository;
import sia.taco_cloud.model.User;
import sia.taco_cloud.order.TacoOrder;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    List<TacoOrder> findByDeliveryZip(String deliveryZip);

    List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(
            String deliveryZip, Date startDate, Date endDate);

    List<TacoOrder> findByUserOrderByPlacedAtDesc (User user, Pageable pageable);
}
