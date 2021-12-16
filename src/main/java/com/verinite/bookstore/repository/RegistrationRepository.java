package com.verinite.bookstore.repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verinite.bookstore.entity.Registration;
@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer>{

	@Query(value="select * from tbl_registration where is_delete=false", nativeQuery = true)
    List<Registration> getAllUser(boolean isDelete);
}
