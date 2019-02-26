package iad.service;

import iad.model.Resource;
import iad.model.User;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface InventoryService {

    void addResourceToInventory(Resource resource, User user, long quantity);
}
