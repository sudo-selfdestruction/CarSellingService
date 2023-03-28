package com.CarSellingService.repository;

import com.CarSellingService.entity.Roles;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Roles, Long> {
}
