package test.acf.challenger.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.acf.challenger.model.CustomerEntity;
import test.acf.challenger.service.ICustomerService;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/health")
    public String health() {
        return "Everything is fine here!";
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "3") int size) {

        Map<String, Object> customers = customerService.findAll( page, size );
        return new ResponseEntity<>(customers, customers.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CustomerEntity>> getById(@PathVariable Integer id) {
        Optional<CustomerEntity> customer = customerService.findById(id);

        return new ResponseEntity<>(customer, customer.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customer) {
        CustomerEntity customerEntity= customerService.create(customer);

        return new ResponseEntity<>(customerEntity, Objects.isNull(customerEntity) ? HttpStatus.NO_CONTENT :
                HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Boolean> updateCustomer(@RequestBody CustomerEntity customerUpdate) {
        return new ResponseEntity<>(customerService.update(customerUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable Integer id) {
        return new ResponseEntity<>(customerService.remove(id), HttpStatus.NO_CONTENT);
    }


}
