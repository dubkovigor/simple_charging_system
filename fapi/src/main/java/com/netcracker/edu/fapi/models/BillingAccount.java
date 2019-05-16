package com.netcracker.edu.fapi.models;

public class BillingAccount {
    private long id;
    private boolean active;
    private Wallet wallet;

    public BillingAccount() {}

    public BillingAccount(long id, boolean active, Wallet wallet) {
        this.id = id;
        this.active= active;
        this.wallet = wallet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "BillingAccount{" +
                "id=" + id +
                ", active=" + active +
                ", wallet=" + wallet +
                '}';
    }
}
