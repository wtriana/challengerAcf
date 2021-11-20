package test.acf.challenger.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.acf.challenger.model.CustomerEntity;
import test.acf.challenger.model.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public CustomerEntity create(CustomerEntity customer) {
        LOGGER.debug("llegando a creación de Cliente");
        return customerRepository.save(customer);
    }
}
