package com.CarSellingService.repository;

import com.CarSellingService.entity.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Roles, Long> {
}
