package iad.repository;

import iad.dto.ImageRow;
import iad.model.Image;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<Image, Long> {

    @Query("select new iad.dto.ImageRow(img.imageId, img.name) from Image img")
    List<ImageRow> getImageRows();

    Image getByImageId(long imageId);
}
