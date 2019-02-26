package iad.service;

import iad.model.Resource;
import iad.model.ResourceInventory;
import iad.model.ResourceInventoryKey;
import iad.model.User;
import iad.repository.ResourceInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    private ResourceInventoryRepository resourceInventoryRepository;

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
}
