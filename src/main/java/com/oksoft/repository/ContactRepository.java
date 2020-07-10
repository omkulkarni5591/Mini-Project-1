package com.oksoft.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oksoft.entities.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Serializable> {

}
