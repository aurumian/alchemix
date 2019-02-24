export default class {
    username;
    imageId;
    money;
    role;
    isInClan;
    isLeader;

    constructor(username, imageId, money, role){
        this.username = username;
        this.money = money;
        this.role = role;
        this.imageId = imageId;
    }
}