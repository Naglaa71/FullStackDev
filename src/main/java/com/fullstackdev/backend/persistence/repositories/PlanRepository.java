package com.fullstackdev.backend.persistence.repositories;

import com.fullstackdev.backend.persistence.domain.backend.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nagla on 9/28/2016.
 */
@Repository
public interface PlanRepository extends CrudRepository<Plan,Integer> {
}
