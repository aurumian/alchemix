package iad.repository;

import iad.dto.ClanDto;
import iad.model.Clan;
import iad.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClanRepository extends CrudRepository<Clan, Long> {
    boolean existsByName(String name);

    boolean existsByClansmen(User us);

    @Query("select new iad.dto.ClanDto(c.name, c.description, c.clanId) from Clan c")
    List<ClanDto> getRows();
}
