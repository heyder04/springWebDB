package com.company.dao.impl;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer>, UserRepositoryCustom {
 User findByName(String nm);
 User findByNameAndSurname(String nm,String sm);

// @Query(value = "select * from user where email=?",nativeQuery = true)
 @Query(value = "select u from  User u where u.email=:email")
 User findByEmail(@Param("email") String email);
}
