/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.paymentchain.costumer.repository;

import com.paymentchain.costumer.entities.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gaelfranco
 */
public interface CostumerRepository extends JpaRepository<Costumer, Long> {
    
}
