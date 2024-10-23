package com.example.ed_demo.Repository;

import com.example.ed_demo.Entities.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="users")
public interface UserRepo  extends JpaRepository<User, Integer>{
    @Query("select p from users p where p.userIn = ?1")
    List<User> findAll(User user);

    //boolean findFirstByUserIn(User userIn);

    @Query("select distinct p from Postponement p where p.userIn = ?1")
    Optional<User> findDistinctByUser(User user);
}
