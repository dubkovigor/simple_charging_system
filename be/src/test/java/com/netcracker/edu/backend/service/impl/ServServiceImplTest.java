package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Serv;
import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.repository.ServRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class ServServiceImplTest {

    @Mock
    private ServRepository servRepository;

    @Test
    public void contextLoads() {
        assertThat(servRepository).isNotNull();
    }

    List<Serv> servs;
    Serv serv;

    @Before
    public void setUp() {
        serv = new Serv();
        serv.setPrice(100);
        serv.setId(1);
        serv.setCategory("TV");
        serv.setServiceName("TV10000");
        servs = new ArrayList<>();
        servs.add(serv);

        Mockito.when(servRepository.findByCategory(serv.getCategory()))
                .thenReturn(servs);
    }

    @Test
    public void whenCategoryRight() {
        String category = "TV";
        List<Serv> found = servRepository.findByCategory(category);
        Assert.assertEquals(servs, found);
    }

    @Test
    public void findByServiceNameWhenServiceNameRight() {
        Mockito.when(servRepository.findByServiceName(serv.getServiceName()))
                .thenReturn(serv);
        String serviceName = "TV10000";
        Serv found = servRepository.findByServiceName(serviceName);
        Assert.assertEquals(serv, found);
    }

    @Test
    public void whenValidNameThenUserShouldBeFound() {
        Mockito.when(servRepository.findById(serv.getId()))
                .thenReturn(serv);
        long id = 1;
        Serv found = servRepository.findById(id);
        Assert.assertEquals(serv, found);
    }

}