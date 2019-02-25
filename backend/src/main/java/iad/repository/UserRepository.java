package iad.repository;


import iad.model.ResourceInventory;
import iad.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User getOneByUsername(String Username);

    User getOneByUserId(long userId);
}
