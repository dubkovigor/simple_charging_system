package com.netcracker.edu.backend.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "billing_account")
public class BillingAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "Active")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private boolean active;

    @OneToOne (cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "walletId", referencedColumnName = "id")
    private Wallet wallet;

    public BillingAccount() {
    }

    public BillingAccount(boolean active) {
        this.active = active;
    }

    public BillingAccount(boolean active, Wallet wallet) {
        this.active = active;
        this.wallet = wallet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillingAccount that = (BillingAccount) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(active, that.active) &&
                Objects.equals(wallet, that.wallet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, active, wallet);
    }
}
