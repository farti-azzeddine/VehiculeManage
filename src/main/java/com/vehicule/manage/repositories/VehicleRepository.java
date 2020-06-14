package com.vehicule.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.manage.models.Vehicle;;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
