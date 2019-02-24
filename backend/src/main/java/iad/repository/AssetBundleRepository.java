package iad.repository;

import iad.dto.AssetBundleRow;
import iad.model.AssetBundle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssetBundleRepository extends CrudRepository<AssetBundle, Long> {

    AssetBundle getByName(String name);

    @Query("select new iad.dto.AssetBundleRow(ab.assetBundleId, ab.name) from AssetBundle ab")
    List<AssetBundleRow> getRows();
}
