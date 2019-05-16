package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private long id;
    private String login;
    private String password;
    private Role role;
    private String firstName;
    private String secondName;
    private BillingAccount ba_Id;
    private Set<Serv> servs;

    public User() {
    }

    public User(long id, String login, String password, Role role, String firstName, String secondName, BillingAccount ba_Id, Set<Serv> servs) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.secondName = secondName;
        this.ba_Id = ba_Id;
        this.servs = servs;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", ba_Id=" + ba_Id +
                ", servs=" + servs +
                '}';
    }
}
