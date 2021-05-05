package co.software.apiinventory.repository.user;

import co.software.apiinventory.model.security.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <User, Integer> {
    User findByUserName(String userName);
}
