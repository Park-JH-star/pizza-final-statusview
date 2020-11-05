package pizza;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatusViewRepository extends CrudRepository<StatusView, Long> {

    List<StatusView> findByOrderId(Long orderId);
}