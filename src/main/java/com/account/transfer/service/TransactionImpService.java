package com.account.transfer.service;

import com.account.transfer.models.AccountImp;
import com.account.transfer.models.TransactionImp;
import com.account.transfer.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionImpService {
    @Autowired
    TransactionRepository transactionRepository;

    //saving a specific record by using the method save() of CrudRepository
    public TransactionImp save(TransactionImp transactionImp) {
        return transactionRepository.save(transactionImp);
    }


}
