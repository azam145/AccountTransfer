package com.account.transfer.controller;

import com.account.transfer.models.AccountImp;
import com.account.transfer.models.TransactionImp;
import com.account.transfer.service.AccountImpService;
import com.account.transfer.service.TransactionImpService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class TransferController {

    protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    AccountImpService accountService;

    @Autowired
    TransactionImpService transactionsService;


    private static BigDecimal MAX_BALANCE_TRANSFER_PER_DAY = new BigDecimal(10000000);


    @PostMapping("/transfer")
    public HttpStatus transfer(@RequestBody TransactionImp transfer) {

        try {
                if (transfer.getAmount().compareTo(MAX_BALANCE_TRANSFER_PER_DAY)==-1 ) {
                    TransactionImp transfered = transactionsService.save(transfer);
                    BigDecimal amount = transfered.getAmount();
                    Long destinationAccount = Long.parseLong(transfer.getDestinationAccount());
                    Optional<AccountImp> account = accountService.findById(destinationAccount);
                    if (account.isPresent()) {
                        BigDecimal newBalance = account.get().getAmount().add(amount);
                        account.get().setAmount(newBalance);
                        AccountImp account1 = account.get();
                        accountService.save(account1);
                    }
                    else return HttpStatus.NOT_FOUND;
                } else {

                   return HttpStatus.BAD_REQUEST;
                }

            }  catch (Exception e) {
                  return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.ACCEPTED;
    }

}
