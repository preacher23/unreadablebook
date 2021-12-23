package com.verinite.bookstore.service;

import java.util.List;


import com.verinite.bookstore.entity.Delivery;

public interface DeliveryService {
  public   Object updateDelivery(int id,Delivery delivery);
  public String deletedelivery(int id);
   public List<Delivery> getdelivery();

  public   Object getById(int id);

  public   Delivery createDelivery(Delivery delivery);
}
