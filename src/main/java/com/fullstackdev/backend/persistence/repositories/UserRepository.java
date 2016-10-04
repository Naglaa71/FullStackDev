package com.fullstackdev.backend.persistence.repositories;

import com.fullstackdev.backend.persistence.domain.backend.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nagla on 9/28/2016.
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long>{

    public User findByUsername(String username);
}
