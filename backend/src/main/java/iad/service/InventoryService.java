package iad.service;

import iad.dto.ResourceInventoryDto;
import iad.model.Resource;
import iad.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface InventoryService {

    void addResourceToInventory(Resource resource, User user, long quantity);

    List<ResourceInventoryDto> getUserInventory(String username);

    long removeResourceFromInventory(Resource resource, User user, long quantity);
}
