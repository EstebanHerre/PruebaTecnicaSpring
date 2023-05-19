package com.prueba.spring.Service;

import java.util.List;

import com.prueba.spring.Model.Customer;

public interface CustomerService {

    public List<Customer> ConsultarCustomer();

    public Customer CrearCustomer(Customer customer);

    public Customer ModificarCustomer(Customer Customer);

    public Customer BuscarCustomer(int id);

    public void BorrarCustomer(int id);
}
