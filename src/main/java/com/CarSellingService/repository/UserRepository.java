package com.CarSellingService.repository;

import com.CarSellingService.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE username = :login")
    User getUserByLogin(String login);

}
