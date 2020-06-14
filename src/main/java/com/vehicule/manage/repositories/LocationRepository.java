package com.vehicule.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.manage.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
