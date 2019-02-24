package iad.repository;

import iad.dto.ClanDto;
import iad.model.Clan;
import iad.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface ClanRepository extends CrudRepository<Clan, Long> {
    boolean existsByName(String name);

    boolean existsByClansmen(User us);

    boolean existsByLeader(User leader);

    @Query("select new iad.dto.ClanDto(c.name, c.description, c.imageId) from Clan c")
    List<ClanDto> getRows();

    long countClansmenByName(String name);

    @Nullable
    Clan findByName(String name);

    @Query("select new iad.dto.ClanDto(c.name, c.description, c.imageId) from Clan c where lower(c.name) like ?1%")
    List<ClanDto> getRowsByQuery(String query);
}
