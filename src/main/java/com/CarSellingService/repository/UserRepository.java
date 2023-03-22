package com.CarSellingService.repository;

import com.CarSellingService.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
