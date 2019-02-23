package iad.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "userSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @Column(name = "USER_ID")
    private long userId;

    private String username;

    private String password;

    private long money;

    @Column(name = "image_id")
    private long imageId;

    @Column(name = "last_time_online")
    private Date lastTimeOnline;

    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "clan_id")
    private Long clanId;

    public User(){

    }

    public User(String username, String password){
        this(username,password, "ROLE_USER");
    }

    public User(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = new Role(role);
        this.lastTimeOnline = new Date();
        this.money = 100;
        this.clanId = null;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public Date getLastTimeOnline() {
        return lastTimeOnline;
    }

    public void setLastTimeOnline(Date lastTimeOnline) {
        this.lastTimeOnline = lastTimeOnline;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public long getClanId() {
        return clanId;
    }

    public void setClanId(long clanId) {
        this.clanId = clanId;
    }
}
