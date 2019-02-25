package iad.repository;

import iad.model.ResourceInventory;
import iad.model.ResourceInventoryKey;
import org.springframework.data.repository.CrudRepository;

public interface ResourceInventoryRepository extends CrudRepository<ResourceInventory, Long> {

    ResourceInventory findById(ResourceInventoryKey id);
}
