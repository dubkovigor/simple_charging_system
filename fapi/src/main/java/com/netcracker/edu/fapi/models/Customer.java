//package com.netcracker.edu.fapi.models;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import java.util.List;
//import java.util.Set;
//
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class Customer {
//    private long id;
//    private String firstName;
//    private String secondName;
//    private BillingAccount ba_Id;
//    private User userID;
//    private Set<Serv> servs;
//
//    public Customer() {
//    }
//
//    public Customer(long id, String firstName, String secondName, BillingAccount ba_Id, User userID, Set<Serv> servs) {
//        this.id = id;
//        this.firstName = firstName;
//        this.secondName = secondName;
//        this.ba_Id = ba_Id;
//        this.userID = userID;
//        this.servs = servs;
//    }
//
//    public void setId(long id) {
//        this.id = id;
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
//    public User getUserID() {
//        return userID;
//    }
//
//    public void setUserID(User userID) {
//        this.userID = userID;
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
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
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
//    public String toString() {
//        return "Customer{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", secondName='" + secondName + '\'' +
//                ", user=" + userID +
//                ", billingAccount=" + ba_Id +
//                ", servs=" + servs +
//                '}';
//    }
//}
//
//
