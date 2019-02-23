package iad.dto;

public class UserDto {

    public String username;
    public long imageId;
    public String role;
    public long money;

    public UserDto(String username, long imageId, String role, long money){
        this.username = username;
        this.imageId = imageId;
        this.role = role;
        this.money = money;
    }
}
