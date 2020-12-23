package com.netcracker.edu.fapi.models;

public class Serv {
    private long id;
    private String serviceDescription;
    private String serviceName;
    private long price;
    private String category;
    private String picturePath;

    public Serv() {}

    public Serv(long id, String serviceDescription, String serviceName, long price, String category, String picturePath) {
        this.id = id;
        this.serviceDescription = serviceDescription;
        this.serviceName = serviceName;
        this.price = price;
        this.category = category;
        this.picturePath = picturePath;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public String toString() {
        return "Serv{" +
                "id=" + id +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", price=" + price +
                '}';
    }
}
