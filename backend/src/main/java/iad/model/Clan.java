package iad.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Clan {

    @Id
    @Column(name = "clan_id")
    @SequenceGenerator(name = "clan_seq", sequenceName = "clan_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clan_seq")
    private long clanId;

    private String name;

    @OneToOne
    @JoinColumn(name = "leader_id", referencedColumnName = "user_id")
    private User leader;

    @OneToMany(mappedBy = "clan")
    private Set<User> clansmen;

    @Column(name = "image_id")
    private long imageId;

    @OneToMany(mappedBy = "clan")
    private Set<ClanPost> posts;

    public long getClanId() {
        return clanId;
    }

    public void setClanId(long clanId) {
        this.clanId = clanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public Set<ClanPost> getPosts() {
        return posts;
    }

    public void setPosts(Set<ClanPost> posts) {
        this.posts = posts;
    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    public Set<User> getClansmen() {
        return clansmen;
    }

    public void setClansmen(Set<User> clansmen) {
        this.clansmen = clansmen;
    }
}
