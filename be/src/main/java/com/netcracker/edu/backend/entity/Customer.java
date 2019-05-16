//package com.netcracker.edu.backend.entity;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Objects;
//import java.util.Set;
//
//@Entity
//@Table(name = "customer")
//public class Customer {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "Id")
//    private long id;
//
////    @Column(name = "FirstName")
////    private String firstName;
////
////    @Column(name = "SecondName")
////    private String secondName;
////
////    @OneToOne(cascade = {
////        CascadeType.PERSIST,
////            CascadeType.MERGE
////    })
////    @JoinColumn(name = "UserID", referencedColumnName = "Id")
////    private User userID;
////
////    @OneToOne(cascade = {
////            CascadeType.PERSIST,
////            CascadeType.MERGE
////    })
////    @JoinColumn(name = "ba_id", referencedColumnName = "Id")
////    private BillingAccount ba_Id;
////
////    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
////    @JsonBackReference
////    @JoinTable(name = "serv_customers",
////            joinColumns = @JoinColumn(name = "customers_id"),
////            inverseJoinColumns = @JoinColumn(name = "servs_id")
////    )
////    private Set<Serv> servs = new HashSet<>();
//
//    public Customer() {
//    }
//
//    public Customer(String firstName, String secondName, User userID, BillingAccount ba_Id, Set<Serv> servs) {
//        this.firstName = firstName;
//        this.secondName = secondName;
//        this.userID = userID;
//        this.ba_Id = ba_Id;
//        this.servs = servs;
//    }
//
//    public Set<Serv> getServs() {
//        return servs;
//    }
//
//    public void setServs(Set<Serv> servs) {
//        this.servs = servs;
//    }
//
//    public User getUserID() {
//        return userID;
//    }
//
//    public void setUserID(User userID) {
//        this.userID = userID;
//    }
//
//    public BillingAccount getBa_Id() {
//        return ba_Id;
//    }
//
//    public void setBa_Id(BillingAccount ba_Id) {
//        this.ba_Id = ba_Id;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getSecondName() {
//        return secondName;
//    }
//
//    public void setSecondName(String secondName) {
//        this.secondName = secondName;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Customer customer = (Customer) o;
//        return Objects.equals(id, customer.id) &&
//                Objects.equals(firstName, customer.firstName) &&
//                Objects.equals(secondName, customer.secondName) &&
//                Objects.equals(userID, customer.userID);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, firstName, secondName, userID);
//    }
//}
