package com.vehicule.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.manage.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
