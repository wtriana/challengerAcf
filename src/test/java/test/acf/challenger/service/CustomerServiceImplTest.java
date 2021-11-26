package test.acf.challenger.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import test.acf.challenger.model.CustomerEntity;
import test.acf.challenger.model.CustomerRepository;

import java.util.*;

import static org.mockito.Mockito.*;

public class CustomerServiceImplTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerServiceImpl customerService;

    @Mock
    private Page<CustomerEntity> customerEntityPage;
    private CustomerEntity customerEntity = new CustomerEntity();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        customerEntity.setId(1);
        customerEntity.setFirstName("firstName");
        customerEntity.setSurName("surName");
        customerEntity.setCustomerId("123456798");
        customerEntity.setCustAge(20);
        customerEntity.setCreationDate(new Date());
    }

    @Test
    public void findAll() {
        List<CustomerEntity> customers = new ArrayList<>();
        customers.add(this.customerEntity);
        Page<CustomerEntity> page = new PageImpl<>(customers, PageRequest.of(1, 3), 400L);
        when(customerRepository.findAll(any(Pageable.class))).thenReturn(page);

        Map<String, Object> result = customerService.findAll(0,1);
        Assert.assertFalse(result.isEmpty());
    }

    @Test
    public void findStringSearch() {
        List<CustomerEntity> customers = new ArrayList<>();
        customers.add(this.customerEntity);
        Page<CustomerEntity> page = new PageImpl<>(customers, PageRequest.of(1, 3), 400L);
        when(customerRepository.findByFirstNameOrSurNameIgnoreCase(anyString(),anyString(),any(Pageable.class))).thenReturn(page);

        Map<String, Object> result = customerService.findStringSearch("","",0,1);
        Assert.assertFalse(result.isEmpty());
    }

    @Test
    public void findById() {
        when(customerRepository.findById(anyInt())).thenReturn(Optional.ofNullable(customerEntity));

        Optional<CustomerEntity> customer = customerService.findById(1);
        Assert.assertTrue(customer.isPresent());
    }

    @Test
    public void create() {
        when(customerRepository.save(any(CustomerEntity.class))).thenReturn(new CustomerEntity());

        CustomerEntity customerCreated = customerService.create(customerEntity);
        Assert.assertNotNull(customerCreated);
    }

    @Test
    public void update() {
        when(customerRepository.findById(anyInt())).thenReturn(Optional.ofNullable(customerEntity));
        when(customerRepository.save(any(CustomerEntity.class))).thenReturn(null);

        Boolean result = customerService.update(customerEntity);
        Assert.assertTrue(result);
    }

    @Test
    public void updateNotFound() {
        when(customerRepository.findById(anyInt())).thenReturn(Optional.ofNullable(null));

        Boolean result = customerService.update(customerEntity);
        Assert.assertFalse(result);
    }

    @Test
    public void remove() {
        when(customerRepository.findById(anyInt())).thenReturn(Optional.ofNullable(customerEntity));

        Boolean result = customerService.remove(1);
        Assert.assertTrue(result);
    }

    @Test
    public void removeNotFound() {
        when(customerRepository.findById(anyInt())).thenReturn(Optional.ofNullable(null));

        Boolean result = customerService.remove(1);
        Assert.assertFalse(result);
    }


}