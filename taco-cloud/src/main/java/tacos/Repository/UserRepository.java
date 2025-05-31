package tacos.Repository;

import org.springframework.data.repository.CrudRepository;
import tacos.Entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
