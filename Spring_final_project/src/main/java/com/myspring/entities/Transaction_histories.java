package com.myspring.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction_histories")
public class Transaction_histories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Users manager_id;
    @ManyToOne
    @JoinColumn(name = "sender_account_id")
    private Accounts sender_account_id;
    @ManyToOne
    @JoinColumn(name = "receiver_account_id")
    private Accounts receiver_account_id;
    @ManyToOne
    @JoinColumn(name = "operation_id")
    private Operations operations;
    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currencies currencies;
    @Column(name = "amount")
    private double amount;
    @Column(name = "operation_time")
    private Date operation_time;


    public Transaction_histories() {
    }

    public Transaction_histories(Users manager_id, Accounts sender_account_id, Accounts receiver_account_id, Operations operations, Currencies currencies, double amount, Date operation_time) {
        this.manager_id = manager_id;
        this.sender_account_id = sender_account_id;
        this.receiver_account_id = receiver_account_id;
        this.operations = operations;
        this.currencies = currencies;
        this.amount = amount;
        this.operation_time = operation_time;
    }

    public Transaction_histories(Long id, Users manager_id, Accounts sender_account_id, Accounts receiver_account_id, Operations operations, Currencies currencies, double amount, Date operation_time) {
        this.id = id;
        this.manager_id = manager_id;
        this.sender_account_id = sender_account_id;
        this.receiver_account_id = receiver_account_id;
        this.operations = operations;
        this.currencies = currencies;
        this.amount = amount;
        this.operation_time = operation_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getManager_id() {
        return manager_id;
    }

    public void setManager_id(Users manager_id) {
        this.manager_id = manager_id;
    }

    public Accounts getSender_account_id() {
        return sender_account_id;
    }

    public void setSender_account_id(Accounts sender_account_id) {
        this.sender_account_id = sender_account_id;
    }

    public Accounts getReceiver_account_id() {
        return receiver_account_id;
    }

    public void setReceiver_account_id(Accounts receiver_account_id) {
        this.receiver_account_id = receiver_account_id;
    }

    public Operations getOperations() {
        return operations;
    }

    public void setOperations(Operations operations) {
        this.operations = operations;
    }

    public Currencies getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Currencies currencies) {
        this.currencies = currencies;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getOperation_time() {
        return operation_time;
    }

    public void setOperation_time(Date operation_time) {
        this.operation_time = operation_time;
    }
}
