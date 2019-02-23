package iad.repository;

import iad.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String Role);
}
