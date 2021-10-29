package com.account.transfer.controller;

import com.account.transfer.TransferApplication;
import com.account.transfer.models.AccountImp;
import com.account.transfer.models.TransactionImp;
import com.account.transfer.service.AccountImpService;
import com.account.transfer.service.TransactionImpService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringRunner.class)
//@WebMvcTest(TransferController.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK, classes={ TransferApplication.class })
public class TransferControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private AccountImpService accountService;

    @MockBean
    private TransactionImpService transactionsService;

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void testSucessfulTransfer() throws Exception {

        TransactionImp transaction = new TransactionImp("12345678", "123456779", new BigDecimal(100000), new Date(2021,12,12));
        AccountImp account = new AccountImp(new BigDecimal(1000));
        account.setId(123L);
        TransactionImp trans = new TransactionImp("12345678", "123456779",  new BigDecimal(100000), new Date(2021,12,12));
        trans.setId(1234L);
        when(accountService.findById(123456779L)).thenReturn(java.util.Optional.of(account));
        when(transactionsService.save(transaction)).thenReturn(trans);


        List<TransactionImp> list = new ArrayList<>();
        list.add(transaction);
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]").create();
        String json = gson.toJson(transaction);

        this.mockMvc.perform( MockMvcRequestBuilders.post("/transfer").content(json).contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());
    }

    @Test
    public void testUnSucessfulTransfer() throws Exception {

        TransactionImp transaction = new TransactionImp("12345678", "123456779", new BigDecimal(100000), new Date(2021,12,12));
        AccountImp account = new AccountImp(new BigDecimal(1000));
        account.setId(123L);
        TransactionImp trans = new TransactionImp("12345678", "123456779",  new BigDecimal(100000), new Date(2021,13,12));
        trans.setId(1234L);
        when(accountService.findById(123456778L)).thenReturn(java.util.Optional.of(account));
        when(transactionsService.save(transaction)).thenReturn(trans);


        List<TransactionImp> list = new ArrayList<>();
        list.add(transaction);
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]").create();
        String json = gson.toJson(transaction);

        this.mockMvc.perform( MockMvcRequestBuilders.post("/transfer").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    // ** TODO more tests ***/

}
