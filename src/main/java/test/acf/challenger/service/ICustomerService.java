package test.acf.challenger.service;

import test.acf.challenger.model.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    //List<HeroEntity> findAll();

    //Optional<HeroEntity> findById(Integer id);

    CustomerEntity create(CustomerEntity customer);

    Boolean update(CustomerEntity customerUpdate);

    Boolean remove(Integer id);

}
