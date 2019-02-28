export default class {
    name;
    description;
    tier;
    imageId;
    assetName;

    constructor(name, description, tier, imageId, assetName){
        this.name = name;
        this.description = description;
        this.tier = tier;
        this.imageId = imageId;
        this.assetName = assetName;
    }
}