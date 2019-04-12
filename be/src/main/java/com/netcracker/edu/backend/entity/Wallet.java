package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Amount")
    private Long amount;

    @OneToOne(mappedBy = "wallet")
    private BillingAccount billingAccount;

    public Wallet() {}

    public Wallet(Long amount, BillingAccount billingAccount) {
        this.amount = amount;
        this.billingAccount = billingAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(id, wallet.id) &&
                Objects.equals(amount, wallet.amount) &&
                Objects.equals(billingAccount, wallet.billingAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, billingAccount);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
