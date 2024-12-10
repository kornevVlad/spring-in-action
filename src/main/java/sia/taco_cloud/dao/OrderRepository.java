package sia.taco_cloud.dao;

import sia.taco_cloud.order.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder tacoOrder);
}
