package com.study.springbootstarterrestdemo.repository;

import com.study.springbootstarterrestdemo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "users")
public interface UsersRepository extends JpaRepository<Users,Integer> {
    Users findByUsername(@Param("username") String username);
}
