package iad.service;

import iad.dto.ResourceInventoryDto;
import iad.model.Resource;
import iad.model.ResourceInventory;
import iad.model.ResourceInventoryKey;
import iad.model.User;
import iad.repository.ResourceInventoryRepository;
import iad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    private ResourceInventoryRepository resourceInventoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addResourceToInventory(Resource resource, User user, long quantity) {

        if (quantity <= 0)
            throw new IllegalArgumentException("quantity must be greater than 0");

        ResourceInventoryKey id = new ResourceInventoryKey(user, resource);

        ResourceInventory resourceInventory =
                resourceInventoryRepository.findById(id);

        if (resourceInventory != null){
            resourceInventory.setQuantity(resourceInventory.getQuantity() + quantity);
        }
        else{
            resourceInventory = new ResourceInventory(id, quantity);
        }
        resourceInventoryRepository.save(resourceInventory);
    }

    @Override
    public List<ResourceInventoryDto> getUserInventory(String username) {
        return resourceInventoryRepository.getUserResources(userRepository.findByUsername(username));
    }

    @Override
    public long removeResourceFromInventory(Resource resource, User user, long quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("quantity must be greater than 0");

        ResourceInventoryKey id = new ResourceInventoryKey(user, resource);

        ResourceInventory resourceInventory =
                resourceInventoryRepository.findById(id);

        if (resourceInventory == null)
            throw new IllegalArgumentException("user doesn't have this resource in inventory");

        long newQuantity = resourceInventory.getQuantity() - quantity;

        if (newQuantity < 0)
            throw new IllegalArgumentException("quantity must be less or equal to quantity of resource user has in inventory");

        if (newQuantity == 0)
            resourceInventoryRepository.delete(resourceInventory);
        else {
            resourceInventory.setQuantity(newQuantity);
            resourceInventoryRepository.save(resourceInventory);
        }

        return newQuantity;
    }
}