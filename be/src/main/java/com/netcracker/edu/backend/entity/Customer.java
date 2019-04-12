package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "SecondName")
    private String secondName;

    @OneToOne(cascade = {
        CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "UserID", referencedColumnName = "Id")
    private User userID;

    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "ba_id", referencedColumnName = "Id")
    private BillingAccount ba_Id;

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public BillingAccount getBa_Id() {
        return ba_Id;
    }

    public void setBa_Id(BillingAccount ba_Id) {
        this.ba_Id = ba_Id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

//    public BillingAccount getBillingAccount() {
//        return billingAccount;
//    }
//
//    public void setBillingAccount(BillingAccount billingAccount) {
//        this.billingAccount = billingAccount;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(secondName, customer.secondName) &&
                Objects.equals(userID, customer.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, userID);
    }
}
