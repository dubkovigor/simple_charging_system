package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.BillingAccount;
import com.netcracker.edu.backend.entity.Serv;
import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.service.ServService;
import com.netcracker.edu.backend.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest()
@WebAppConfiguration
public class UserControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Mock
    private UserController userController;
    @Mock
    private UserService userService;
    @Mock
    private ServService servService;

    protected MockMvc mvc;

    @Before
    public void setUp() {
        userController = new UserController(userService, servService);
    }

    @Test
    public void contextLoads() {
        assertThat(userController).isNotNull();
        assertThat(userService).isNotNull();
        assertThat(servService).isNotNull();
    }

    @Test
    public void writeOffMoney() {
        userController = new UserController(userService, servService);
        Assert.assertEquals(20, userController.writeOffMoney(createUser(), createService()).getBa_Id().getWallet().getAmount());
    }

    @Test
    public void writeOffMoneyIfNoEquals() {
        userController = new UserController(userService, servService);
        Assert.assertNotEquals(21, userController.writeOffMoney(createUser(), createService()).getBa_Id().getWallet().getAmount());
    }

    @Test
    public void getAllUsers() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String uri = "/api/user";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void getAllUserByFirstName() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String uri = "/api/user/firstname/name";
        User user = new User();
        user.setFirstName("alex");
        when(userService.findByFirstName(anyString())).thenReturn(user);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    private Serv createService() {
        Serv serv = new Serv();
        serv.setPrice(100);
        return serv;
    }

    private User createUser() {
        User user = new User();
        BillingAccount billingAccount = new BillingAccount();
        Wallet wallet = new Wallet();
        wallet.setAmount(120);
        billingAccount.setWallet(wallet);
        user.setBa_Id(billingAccount);
        return user;
    }
}