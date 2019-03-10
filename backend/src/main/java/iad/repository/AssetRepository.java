package iad.repository;

import iad.model.Asset;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssetRepository extends CrudRepository<Asset, Long> {

    Asset getByName(String name);

    List<Asset> findAll();


}
