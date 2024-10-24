package com.example.ed_demo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ed_demo.Entities.HomeAddress;

@RepositoryRestResource(path="home_addresses")
public interface HomeAddrRepo extends JpaRepository<HomeAddress, Integer>{
    @Query("select w from WorkAddress w")
    List<HomeAddress> findAll(HomeAddress homeAddr);
}
