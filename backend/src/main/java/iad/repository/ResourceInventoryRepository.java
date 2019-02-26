package iad.repository;

import iad.dto.ResourceInventoryDto;
import iad.model.ResourceInventory;
import iad.model.ResourceInventoryKey;
import iad.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResourceInventoryRepository extends CrudRepository<ResourceInventory, Long> {

    ResourceInventory findById(ResourceInventoryKey id);

    @Query("select new iad.dto.ResourceInventoryDto(r.resourceId, r.name, r.description, r.tier, r.imageId, r.assetBundleId, ri.quantity) " +
            "from ResourceInventory ri join iad.model.Resource r on ri.id.resource = r where ri.id.user = ?1")
    List<ResourceInventoryDto> getUserResources(User user);
}
