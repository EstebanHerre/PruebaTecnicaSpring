package com.prueba.spring.Service.CustomerServiceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.spring.Model.Customer;
import com.prueba.spring.Repository.CustomerRepo;
import com.prueba.spring.Service.CustomerService;

@Service
public class PSIML implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Override
    public List<Customer> ConsultarCustomer() {

        return (List<Customer>) this.repo.findAll();
    }

    @Override
    public Customer CrearCustomer(Customer customer) {

        customer.setPhone(customer.getPhone());

        return this.repo.save(customer);
    }

    @Override
    public Customer ModificarCustomer(Customer customer) {

        return this.repo.save(customer);
    }

    @Override
    public Customer BuscarCustomer(int id) {

        return this.repo.findById(id).get();
    }

    @Override
    public void BorrarCustomer(int id) {

        this.repo.deleteById(id);
    }

}
