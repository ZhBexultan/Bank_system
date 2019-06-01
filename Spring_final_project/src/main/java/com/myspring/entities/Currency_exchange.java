package com.myspring.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "currency_exchange")
public class Currency_exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "currency_id")
    private Currencies currencies;
    @Column(name = "purchase_value")
    private double purchase_value;
    @Column(name = "sale_value")
    private double sale_value;
    @Column(name = "assigned_time")
    private Date assigned_time;

    public Currency_exchange() {
    }

    public Currency_exchange(Currencies currencies, double purchase_value, double sale_value, Date assigned_time) {
        this.currencies = currencies;
        this.purchase_value = purchase_value;
        this.sale_value = sale_value;
        this.assigned_time = assigned_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Currencies getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Currencies currencies) {
        this.currencies = currencies;
    }

    public double getPurchase_value() {
        return purchase_value;
    }

    public void setPurchase_value(double purchase_value) {
        this.purchase_value = purchase_value;
    }

    public double getSale_value() {
        return sale_value;
    }

    public void setSale_value(double sale_value) {
        this.sale_value = sale_value;
    }

    public Date getAssigned_time() {
        return assigned_time;
    }

    public void setAssigned_time(Date assigned_time) {
        this.assigned_time = assigned_time;
    }
}
