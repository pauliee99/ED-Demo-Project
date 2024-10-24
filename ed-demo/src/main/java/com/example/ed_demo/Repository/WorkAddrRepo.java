package com.example.ed_demo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ed_demo.Entities.WorkAddress;

@RepositoryRestResource(path="work_addresses")
public interface WorkAddrRepo extends JpaRepository<WorkAddress, Integer>{
    @Query("select w from WorkAddress w")
    List<WorkAddress> findAll(WorkAddress workAddr);
}
