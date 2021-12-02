package com.verinite.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verinite.bookstore.entity.Registration;
@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer>{


}
