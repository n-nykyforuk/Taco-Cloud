package tacos.Repository;

import org.springframework.data.repository.CrudRepository;
import tacos.Entity.TacoOrder;
import tacos.Entity.User;
import org.springframework.data.domain.Pageable;
import java.util.*;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

    List<TacoOrder> findByDeliveryZip(String deliveryZip);

    List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(
            String deliveryZip, Date startDate, Date endDate);

    List<TacoOrder> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
