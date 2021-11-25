package test.acf.challenger.model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    Page<CustomerEntity> findByFirstName(String name, Pageable pageable);

    @Query("select * from customers where \"firstName\":cryteria")
    Page<CustomerEntity> findByFirstNameSurName (@Param("cryteria") String cryteria);
}