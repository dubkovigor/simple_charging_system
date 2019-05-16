package com.netcracker.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @Column(name = "roleName")
    private String roleName;

    @OneToMany(mappedBy="role",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<User> user;

    public List<User> getUser() {
        return user;
    }
    public void setUser(List<User> user) {
        this.user = user;
    }

    public Role() {}

    public Role(String roleName, List<User> user) {
        this.roleName = roleName;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) &&
                Objects.equals(roleName, role.roleName) &&
                Objects.equals(user, role.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, user);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
