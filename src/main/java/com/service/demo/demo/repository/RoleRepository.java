package com.service.demo.demo.repository;

import com.service.demo.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {



    Optional<Role> findByName(String name);// select all from roles ,where name =

    void delateByName(String name);

    void deletebyName(String name);
}
