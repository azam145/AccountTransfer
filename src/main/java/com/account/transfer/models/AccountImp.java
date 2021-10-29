package com.account.transfer.models;



import com.account.transfer.interfaces.Account;
import com.account.transfer.interfaces.AccountHolder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.locks.Lock;


@Entity
public class AccountImp implements Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal amount;

    protected AccountImp() {
    }

    public AccountImp(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "AccountImp{" +
                "id=\'" + id +"\'" +
                ", amount='" + amount + "\'" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountImp account = (AccountImp) o;
        return account.amount.equals(amount) && Objects.equals(id, account.id) && Objects.equals(id, account.id) ;
    }

}
