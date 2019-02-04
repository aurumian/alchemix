package iad.repository;

import iad.model.Image;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {

    @Query("select img.imageId from Image img")
    Long[] getImageIds();

}
