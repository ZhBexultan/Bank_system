package com.myspring.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "bank_total_balance")
public class Bank_total_balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "value")
    private double value;
    @OneToOne
    @JoinColumn(name = "currency_id")
    private Currencies currencies;

    public Bank_total_balance() {
    }

    public Bank_total_balance(Long id, double value, Currencies currencies) {
        this.id = id;
        this.value = value;
        this.currencies = currencies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Currencies getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Currencies currencies) {
        this.currencies = currencies;
    }
}
