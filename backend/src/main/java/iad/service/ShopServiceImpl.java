package iad.service;

import iad.model.*;
import iad.repository.ResourceOnSaleRepository;
import iad.repository.ResourceRepository;
import iad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResourceOnSaleRepository resourceOnSaleRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private InventoryService inventoryService;

    @Override
    public long makePurchase(long resourceId, long quantity, long sellerId, String username) {
        if (quantity <= 0)
            throw new IllegalArgumentException("quantity must be greater than 0");

        User user = userRepository.findByUsername(username);

        if (user == null)
            throw new IllegalArgumentException("user with username \"" + username + "\" doesn't exist");

        ResourceOnSale resourceOnSale = resourceOnSaleRepository.
                findById_Seller_UserIdAndId_Resource_ResourceId(sellerId, resourceId);

        if (resourceOnSale == null)
            throw new IllegalArgumentException("No resource found on sale with with resourceId " + resourceId +
                    " and sellerId " + sellerId);

        if (resourceOnSale.getQuantity() > 0 && resourceOnSale.getQuantity() < quantity)
            throw new IllegalArgumentException("requested resource on sale has less quantity then user attempts to buy");

        if (resourceOnSale.getId().getSeller().getUserId() == user.getUserId())
            throw new IllegalArgumentException("user cannot buy from himself");


        long total = resourceOnSale.getPrice()*quantity;

        //handle adding to inventory
        inventoryService.addResourceToInventory(resourceOnSale.getId().getResource(), user, quantity);

        //handle money transition
        if (user.getMoney() < total)
            throw new RuntimeException("user doesn't have enough money");
        user.setMoney(user.getMoney()-total);
        User seller = resourceOnSale.getId().getSeller();
        seller.setMoney(seller.getMoney()+total);
        userRepository.save(user);
        userRepository.save(seller);

        //handle change in quantity
        long newQuantity = resourceOnSale.getQuantity() - quantity;
        if (newQuantity == 0){
            resourceOnSaleRepository.delete(resourceOnSale);
        }
        //if resourceOnSale.getQuantity() < 0 then resource is supposed to be sold infinitely
        else if (resourceOnSale.getQuantity() > 0){
            resourceOnSale.setQuantity(newQuantity);
            resourceOnSaleRepository.save(resourceOnSale);
        }

        return newQuantity;
    }

    @Override
    public long putResourceOnSale(long resourceId, long quantity, long price, String sellerUsername) {
        //validate
        if (quantity <= 0)
            throw new IllegalArgumentException("quantity must be greater than 0");

        if (price <= 0)
            throw new IllegalArgumentException("price must be greater than 0");

        User user = userRepository.findByUsername(sellerUsername);

        if (user == null)
            throw new IllegalArgumentException("user with username \"" + sellerUsername + "\" doesn't exist");

        Resource resource = resourceRepository.findByResourceId(resourceId);

        if (resource == null)
            throw new IllegalArgumentException("resource with resourceId \"" + resourceId + "\" doesn't exist");

        //remove from inventory
        long newQuantity = inventoryService.removeResourceFromInventory(resource, user, quantity);

        //actually put on sale
        resourceOnSaleRepository.save(new ResourceOnSale(quantity, price, user, resource));

        return newQuantity;
    }
}