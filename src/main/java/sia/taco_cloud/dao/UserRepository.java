package sia.taco_cloud.dao;


import org.springframework.data.repository.CrudRepository;
import sia.taco_cloud.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
