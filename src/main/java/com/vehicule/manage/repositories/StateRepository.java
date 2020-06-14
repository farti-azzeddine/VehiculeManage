package com.vehicule.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.manage.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
