package iad.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CLAN_POST")
public class ClanPost {

    @Id
    @Column(name = "postId")
    @SequenceGenerator(name = "clan_post_seq", sequenceName = "clan_post_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clan_post_seq")
    private long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clan_id")
    private Clan clan;

    @Column(name = "post_text")
    private String postText;

    @Column(name = "date_posted")
    private Date datePosted;

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }
}
