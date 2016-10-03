package com.fullstackdev.backend.persistence.repositories;

import com.fullstackdev.backend.persistence.domain.backend.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nagla on 9/28/2016.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
}
