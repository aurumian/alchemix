package iad.model;

import javax.persistence.*;

@Entity
public class Clan {

    @Id
    @Column(name = "clan_id")
    @SequenceGenerator(name = "clan_seq", sequenceName = "clan_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clan_seq")
    private long clanId;

    private String name;

    @Column(name = "leader_id")
    private long leaderId;

    @Column(name = "image_id")
    private long imageId;

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

    public long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(long leaderId) {
        this.leaderId = leaderId;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }
}
