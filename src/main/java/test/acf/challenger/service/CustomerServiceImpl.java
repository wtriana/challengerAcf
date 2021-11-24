package test.acf.challenger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test.acf.challenger.model.CustomerEntity;
import test.acf.challenger.model.CustomerRepository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Map<String, Object> findAll(int page, int size) {
        List<CustomerEntity> customers;
        Pageable paging = PageRequest.of(page, size);
        Page<CustomerEntity> pageCust;
        pageCust = customerRepository.findAll(paging);
        customers = pageCust.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("customers", customers);
        response.put("currentPage", pageCust.getNumber());
        response.put("totalItems", pageCust.getTotalElements());
        response.put("totalPages", pageCust.getTotalPages());
        return response;
    }

    @Override
    public Optional<CustomerEntity> findById(Integer id) {
        return customerRepository.findById(id);
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
