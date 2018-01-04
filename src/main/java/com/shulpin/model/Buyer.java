package com.shulpin.model;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="buyer")
@EnableTransactionManagement
public class Buyer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String secondName;

    private String address;

    private double discount;

    public Buyer() {}

    public Buyer(String secondName, String address, double discount) {
        this.secondName = secondName;
        this.address = address;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buyer buyer = (Buyer) o;

        if (Double.compare(buyer.discount, discount) != 0) return false;
        if (id != null ? !id.equals(buyer.id) : buyer.id != null) return false;
        if (secondName != null ? !secondName.equals(buyer.secondName) : buyer.secondName != null) return false;
        return address != null ? address.equals(buyer.address) : buyer.address == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", secondName='" + secondName + '\'' +
                ", address='" + address + '\'' +
                ", discount=" + discount +
                '}';
    }
}
