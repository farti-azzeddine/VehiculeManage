package com.vehicule.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.manage.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
