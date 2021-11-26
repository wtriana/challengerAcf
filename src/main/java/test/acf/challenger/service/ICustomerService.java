package test.acf.challenger.service;

import test.acf.challenger.model.CustomerEntity;

import java.util.Map;
import java.util.Optional;

public interface ICustomerService {

    Map<String, Object> findAll(int page, int size);

    Map<String, Object> findStringSearch(String firstName, String surName, int page, int size);

    Optional<CustomerEntity> findById(Integer id);

    CustomerEntity create(CustomerEntity customer);

    Boolean update(CustomerEntity customerUpdate);

    Boolean remove(Integer id);

}
