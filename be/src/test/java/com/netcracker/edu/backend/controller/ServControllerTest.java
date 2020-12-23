package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Serv;
import com.netcracker.edu.backend.service.ServService;
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
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest()
@WebAppConfiguration
public class ServControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Mock
    private ServController servController;

    @Mock
    private ServService servService;

    //    @Mock
    protected MockMvc mvc;

    @Before
    public void setUp() {
        servController = new ServController(servService);
    }

    @Test
    public void contextLoads() {
        assertThat(servController).isNotNull();
        assertThat(servService).isNotNull();
    }

    @Test
    public void changePicturePath() {
        Serv serv = new Serv();
        serv.setPicturePath("C:\\fakepath\\picture.jpg");

        assertEquals("/assets/img/picture.jpg", servController.changePicturePath(serv).getPicturePath());
    }

    @Test
    public void changePicturePathIfNoEquals() {
        Serv serv = new Serv();
        serv.setPicturePath("C:\\fakepath\\picture.jpg");

        assertNotEquals("/assets/img/picture1.jpg", servController.changePicturePath(serv).getPicturePath());
    }

    @Test
    public void getAllServices() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String uri = "/api/service";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void getAllServicesByIncorrectUrl() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String uri = "/api/serv";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
    }

    @Test
    public void getServiceByIncorrectServiceName() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String uri = "/service/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
    }
}