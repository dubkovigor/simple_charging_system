package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.repository.RoleRepository;
import com.netcracker.edu.backend.repository.UserRepository;
import com.netcracker.edu.backend.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @Mock
    private UserService userService;

    @Mock
    RoleRepository roleRepository;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp() {
        User alex = new User();
        alex.setFirstName("alex");
        alex.setLogin("alex");
        alex.setId(0);

        Mockito.when(userRepository.findByFirstName(alex.getFirstName()))
                .thenReturn(alex);
        Mockito.when(userRepository.findById(alex.getId()))
                .thenReturn(alex);
        Mockito.when(userRepository.findByLogin(alex.getLogin()))
                .thenReturn(alex);
    }

    @Test
    public void contextLoads() {
        assertThat(userRepository).isNotNull();
        assertThat(roleRepository).isNotNull();
        assertThat(userService).isNotNull();
    }

    @Test
    public void whenValidNameThenUserShouldBeFound() {
        String name = "alex";
        User found = userRepository.findByFirstName(name);
        Assert.assertEquals(name, found.getFirstName());
    }

    @Test
    public void whenValidIdThenUserShouldBeFound() {
        long id = 0;
        User found = userRepository.findById(id);
        Assert.assertEquals(id, found.getId());
    }

    @Test
    public void whenValidLoginThenUserShouldBeFound() {
        String login = "alex";
        User found = userRepository.findByFirstName(login);
        Assert.assertEquals(login, found.getLogin());
    }
}