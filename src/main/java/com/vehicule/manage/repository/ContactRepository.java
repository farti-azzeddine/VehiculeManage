package com.vehicule.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.manage.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
