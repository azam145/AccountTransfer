package com.account.transfer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.account.transfer.models.AccountImp;
import com.account.transfer.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//defining the business logic
@Service
public class AccountImpService {
    @Autowired
    AccountRepository accountRepository;

    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(AccountImp account) {

        accountRepository.save(account);
    }



    // find by account id
    public Optional<AccountImp> findById(Long id) {
        return accountRepository.findById(id);
    }

    public void save(AccountImp account) {
        accountRepository.save(account);
    }

    //updating a record
    // first find and then update
    public void update(AccountImp account, Long accountId) {

        Optional<AccountImp> acct = accountRepository.findById(accountId);
        /** TODO **/
        //
    }
}