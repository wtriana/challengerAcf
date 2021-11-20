package test.acf.challenger.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.acf.challenger.model.CustomerEntity;
import test.acf.challenger.model.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity create(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Boolean update(CustomerEntity customerUpdate) {
        if (customerRepository.findById(customerUpdate.getId()).isPresent()) {
            CustomerEntity customerToUpdate = new CustomerEntity();
            customerToUpdate.setId(customerUpdate.getId());
            customerToUpdate.setFirstName(customerUpdate.getFirstName());
            customerToUpdate.setSurName(customerUpdate.getSurName());
            customerToUpdate.setCustAge(customerUpdate.getCustAge());
            customerRepository.save(customerToUpdate);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean remove(Integer id) {
        if (customerRepository.findById(id).isPresent()) {
            customerRepository.deleteById(id);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
