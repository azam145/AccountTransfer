package com.account.transfer.models;

import com.account.transfer.interfaces.Account;
import com.account.transfer.interfaces.Transaction;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
public class TransactionImp implements Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal amount;
    private String sourceAccount;
    private String destinationAccount;


    private Boolean success;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private Date date;

    protected TransactionImp() {
    }

    public TransactionImp(String sourceAccount, String destinationAccount, BigDecimal amount, Date date) {
        this.amount = amount;
        this.date = date;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {

        return amount;
    }

    public void setAmount(BigDecimal amount) {

        this.amount = amount;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }

    @Override
    public String getSourceAccount() {
        return sourceAccount;
    }

    @Override
    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    @Override
    public String getDestinationAccount() {
        return destinationAccount;
    }

    @Override
    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    @Override
    public Boolean getSuccess() {
        return success;
    }

    @Override
    public void setSuccess(Boolean success) {
        this.success = success;
    }


    @Override
    public String toString() {
        return "TransactionImp{" +
                "id=\'" + id +"\'" +
                ", amount=\'" + amount + "\'" +
                ", date=\'" + date + "\'" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionImp transaction = (TransactionImp) o;
        return transaction.amount.equals(amount) && Objects.equals(id, transaction.id) && Objects.equals(id, transaction.id) && Objects.equals(date, transaction.date);
    }


}
