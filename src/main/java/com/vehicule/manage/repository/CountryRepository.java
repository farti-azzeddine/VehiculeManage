package com.vehicule.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.manage.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
