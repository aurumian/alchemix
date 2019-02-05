export default class {
    name;
    description;
    tier;
    imageId;
    assetBundleId;

    constructor(name, description, tier, imageId, assetBundleId){
        this.name = name;
        this.description = description;
        this.tier = tier;
        this.imageId = imageId;
        this.assetBundleId = assetBundleId;
    }
}