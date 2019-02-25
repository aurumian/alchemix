package iad.repository;

import iad.dto.StoreResource;
import iad.model.ResourceOnSale;
import iad.model.ResourceOnSaleKey;
import iad.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface
ResourceOnSaleRepository extends CrudRepository<ResourceOnSale, Long> {

    ResourceOnSale findById(ResourceOnSaleKey id);

    @Query("select new iad.dto.StoreResource(r.id.resource.name, r.id.resource.description, r.id.resource.tier, " +
            "r.id.resource.imageId, r.quantity, r.price, r.id.seller.userId, r.id.resource.resourceId) from iad.model.User u join ResourceOnSale r on u = r.id.seller where u.role = ?1")
    List<StoreResource> findBySellerRole(Role role);

    ResourceOnSale findById_Seller_UserIdAndId_Resource_ResourceId(long userId, long resourceId);
}
