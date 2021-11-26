package test.acf.challenger.model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    Page<CustomerEntity> findByFirstNameIgnoreCase(String firstName, Pageable pageable);

    Page<CustomerEntity> findByFirstNameOrSurNameIgnoreCase(String firstName, String surName, Pageable pageable);

}