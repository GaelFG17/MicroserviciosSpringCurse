/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paymentchain.costumer.controller;

import com.paymentchain.costumer.entities.Costumer;
import com.paymentchain.costumer.repository.CostumerRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author sotobotero
 */
@RestController
@RequestMapping("/customer")
public class CostumerController {
    
    @Autowired
    CostumerRepository costumerRepository;
    
    @GetMapping()
    public List<Costumer> list() {
        return costumerRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable long id) {
         Optional<Costumer> customer = costumerRepository.findById(id);
        if (customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable long id, @RequestBody Costumer input) {
         Optional<Costumer> optionalcustomer = costumerRepository.findById(id);
        if (optionalcustomer.isPresent()) {
            Costumer newcustomer = optionalcustomer.get();
            newcustomer.setName(input.getName());
            newcustomer.setPhone(input.getPhone());
            Costumer save = costumerRepository.save(newcustomer);
          return new ResponseEntity<>(save, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Costumer input) {
        Costumer save = costumerRepository.save(input);
        return ResponseEntity.ok(save);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
         costumerRepository.deleteById(id);
         return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
