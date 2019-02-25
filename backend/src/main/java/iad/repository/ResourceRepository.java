package iad.repository;

import iad.model.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface ResourceRepository extends CrudRepository<Resource, Long> {

    @Nullable
    List<Resource> findAll();

    Resource findByResourceId(long id);
}
