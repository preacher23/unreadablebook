package com.verinite.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verinite.bookstore.entity.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery,Integer> {
}
