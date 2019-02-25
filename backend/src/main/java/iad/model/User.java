package iad.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "recipe_inventory",
            joinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Recipe> recipes;

    @OneToMany(mappedBy = "id.user", cascade = CascadeType.ALL)
    private Set<ResourceInventory> resourceInventory;

    @OneToMany(mappedBy = "id.seller", cascade = CascadeType.ALL)
    private Set<ResourceOnSale> resourcesOnSale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clan_id")
    private Clan clan;

    public User(){

    }

    public User(String username, String password, Role role){
        this.username = username;
        this.password = password;
        this.role = role;
        this.imageId = 3;
        this.lastTimeOnline = new Date();
        this.money = 100;
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

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Set<ResourceInventory> getResourceInventory() {
        return resourceInventory;
    }

    public void setResourceInventory(Set<ResourceInventory> resourceInventory) {
        this.resourceInventory = resourceInventory;
    }

    public Set<ResourceOnSale> getResourcesOnSale() {
        return resourcesOnSale;
    }

    public void setResourcesOnSale(Set<ResourceOnSale> resourcesOnSale) {
        this.resourcesOnSale = resourcesOnSale;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }
}
