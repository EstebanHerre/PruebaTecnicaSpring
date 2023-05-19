package com.prueba.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.spring.Model.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {

}