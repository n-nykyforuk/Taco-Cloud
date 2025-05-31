package tacos.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import tacos.Entity.Taco;

import java.util.Optional;

public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {

    Optional<Taco> findById(Long id);

    Taco save(Taco taco);
}
