package iad.repository;

import iad.model.Clan;
import iad.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ClanRepository extends CrudRepository<Clan, Long> {
    boolean existsByName(String name);

    boolean existsByClansmen(Set<User> clansmen);

    boolean existsByClansmen(User us);
}
