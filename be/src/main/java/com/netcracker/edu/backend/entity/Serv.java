package com.netcracker.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Serv")
public class Serv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @Column(name = "ServiceName")
    private String serviceName;

    @Column(name = "ServiceDescription")
    private String serviceDescription;

    @Column(name = "Price")
    private long price;

    @Column(name = "PicturePath")
    private String picturePath;

    @Column(name = "Category")
    private String category;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinTable(name = "serv_users",
            joinColumns = @JoinColumn(name = "servs_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Serv() {
    }

//    public Serv(String serviceName, String serviceDescription) {
//        this.serviceName = serviceName;
//        this.serviceDescription = serviceDescription;
//    }


    public Serv(String serviceName, String serviceDescription, long price, Set<User> users, String picturePath) {
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.price = price;
        this.users = users;
        this.picturePath = picturePath;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serv serv = (Serv) o;
        return id == serv.id &&
                price == serv.price &&
                Objects.equals(serviceName, serv.serviceName) &&
                Objects.equals(serviceDescription, serv.serviceDescription) &&
                Objects.equals(picturePath, serv.picturePath) &&
                Objects.equals(category, serv.category) &&
                Objects.equals(users, serv.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceName, serviceDescription, price, picturePath, category, users);
    }

    @Override
    public String toString() {
        return "Serv{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", price=" + price +
                ", picturePath='" + picturePath + '\'' +
                ", category='" + category + '\'' +
                ", users=" + users +
                '}';
    }
}
