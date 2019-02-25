package iad.repository;

import iad.dto.Post;
import iad.model.Clan;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClanPostRepository extends ClanRepository {

    @Query("select new iad.dto.Post(u.username, u.imageId, p.datePosted, p.postText) from ClanPost p join iad.model.User u on p.user = u where p.clan = ?1 order by p.datePosted desc")
    List<Post> getPosts(Clan clan);
}
