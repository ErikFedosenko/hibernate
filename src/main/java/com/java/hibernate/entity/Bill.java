package com.java.hibernate.entity;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billId;

    private Integer amount;

    public Bill(Integer amount) {
        this.amount = amount;
    }

    public Bill() {

    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Bill.class.getSimpleName() + "[", "]")
                .add("billId=" + billId)
                .add("amount=" + amount)
                .toString();
    }
}
