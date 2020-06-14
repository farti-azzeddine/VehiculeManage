package com.vehicule.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.manage.models.Supplier;;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
