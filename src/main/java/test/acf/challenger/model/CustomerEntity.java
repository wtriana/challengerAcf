package test.acf.challenger.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "\"customerId\"", updatable= false)
    private String customerId;

    @Column(name = "\"firstName\"")
    private String firstName;

    @Column(name = "\"surName\"")
    private String surName;

    @Column(name = "\"custAge\"")
    private int custAge;

    @Column(name = "\"creationDate\"", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public CustomerEntity() {
    }

    public CustomerEntity(String customerId, String firstName, String surName, int custAge) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.surName = surName;
        this.custAge = custAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getCustAge() {
        return custAge;
    }

    public void setCustAge(int custAge) {
        this.custAge = custAge;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", custAge=" + custAge +
                ", creationDate=" + creationDate +
                '}';
    }
}
