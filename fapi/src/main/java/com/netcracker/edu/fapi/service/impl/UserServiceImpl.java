package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service("customUserDetailsService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private ArrayList<User> users = new ArrayList<>();

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public User findByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.postForObject(backendServerUrl + "/api/user/login",login, User.class);
        return user;
    }

    @Override
    public User findById(long id) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.postForObject(backendServerUrl + "/api/user/", id, User.class);
        return user;
    }

    @Override
    public List<User> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        User[] usersResponse = restTemplate.getForObject(backendServerUrl + "/api/user", User[].class);
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(usersResponse);
    }

    @Override
    public User findByFirstName(String firstname) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(backendServerUrl + "/api/user/firstname/" + firstname, User.class);
        return user;
    }

    @Override
    public User findBySecondName(String secondname) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(backendServerUrl + "/api/user/secondname/" + secondname, User.class);
        return user;
    }

    @Override
    public User setServ(User user, long serv_id) {
        RestTemplate restTemplate = new RestTemplate();
        User loguser =  restTemplate.postForEntity(backendServerUrl + "api/user/join?service_id=" + serv_id, user, User.class).getBody();
        return loguser;
    }

    @Override
    public User deleteServ(User user, long serv_id) {
        RestTemplate restTemplate = new RestTemplate();
        User loguser =  restTemplate.postForEntity(backendServerUrl + "api/user/refuse?service_id=" + serv_id, user, User.class).getBody();
        return loguser;
    }

    @Override
    public User save(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.postForEntity(backendServerUrl + "/api/user", user, User.class).getBody();
//        users.add(user);
//        return user;
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user", user, User.class).getBody();
    }

    @Override
    public void delete(long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/user/" + id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getRoleName()));
        return authorities;
    }

}
