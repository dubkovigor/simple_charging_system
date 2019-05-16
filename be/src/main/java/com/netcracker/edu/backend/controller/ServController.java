package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Serv;
import com.netcracker.edu.backend.service.ServService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/service")
public class ServController {
    private ServService servService;

    public ServController(ServService servService) {
        this.servService = servService;
    }
    @GetMapping(value = "/service/{serviceName}")
    public ResponseEntity<Serv> getUserByserveName(@PathVariable(name = "serviceName") String serveName) {
        Serv serv = servService.findByServiceName(serveName);
        return ResponseEntity.ok(serv);
    }

    @GetMapping(value = "id/{id}")
    public Serv findServiceById(@PathVariable(name = "id") long id) {
        return servService.findById(id);
    }

    @GetMapping(value = "")
    public List<Serv> getAllService() {
        return servService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Serv saveService(@RequestBody Serv serv) {
        return servService.save(serv);
    }

    @DeleteMapping(value = "/delete/{serviceId}")
    public ResponseEntity delete(@PathVariable (name = "serviceId") long id) {
        servService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/count/{id}")
    public long getCountUsers(@PathVariable(name ="id") long id){
        System.out.println(id);
        return this.servService.findById(id).getUsers().size();
    }
}
