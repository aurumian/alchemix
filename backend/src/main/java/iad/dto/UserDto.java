package iad.dto;

public class UserDto {

    public long userId;
    public String username;
    public long imageId;
    public String role;
    public long money;
    public boolean isInClan;
    public boolean isLeader;

    public UserDto(long userId, String username, long imageId, String role, long money, boolean isInClan, boolean isLeader){
        this.userId = userId;
        this.username = username;
        this.imageId = imageId;
        this.role = role;
        this.money = money;
        this.isInClan = isInClan;
        this.isLeader = isLeader;
    }
}
