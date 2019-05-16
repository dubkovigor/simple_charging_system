package com.netcracker.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "SecondName")
    private String secondName;

    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "ba_id", referencedColumnName = "Id")
    private BillingAccount ba_Id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonManagedReference
    @JoinTable(name = "serv_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "servs_id")
    )
    private Set<Serv> servs;

    @ManyToOne()
    @JoinColumn(name="roleid")
    private Role role;

    public User() {
    }

    public User(String login, String password, String firstName, String secondName, BillingAccount ba_Id, Set<Serv> servs, Role role) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.ba_Id = ba_Id;
        this.servs = servs;
        this.role = role;
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

    public BillingAccount getBa_Id() {
        return ba_Id;
    }

    public void setBa_Id(BillingAccount ba_Id) {
        this.ba_Id = ba_Id;
    }

    public Set<Serv> getServs() {
        return servs;
    }

    public void setServs(Set<Serv> servs) {
        this.servs = servs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(secondName, user.secondName) &&
                Objects.equals(ba_Id, user.ba_Id) &&
                Objects.equals(servs, user.servs) &&
                Objects.equals(role, user.role);
    }

//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, login, password, firstName, secondName, ba_Id, servs, role);
//    }
}
