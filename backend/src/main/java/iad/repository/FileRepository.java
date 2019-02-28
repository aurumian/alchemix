package iad.repository;

import iad.model.File;
import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudRepository<File, Long> {

    File getByFilename(String filename);
}
