package com.prueba.spring.Controller;

import java.util.List;

/* import org.hibernate.mapping.List; */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.spring.Model.Customer;
import com.prueba.spring.Service.CustomerServiceIMPL.PSIML;

@RestController
@RequestMapping("CRUDRepo")
public class Controlador {

    @Autowired
    private PSIML impl;

    @GetMapping
    @RequestMapping(value = "ConsultarCustomers", method = RequestMethod.GET)
    public ResponseEntity<?> ConsultarCustomer() {
        List<Customer> listaCustomer = this.impl.ConsultarCustomer();
        return ResponseEntity.ok(listaCustomer);

    }

    @PutMapping
    @RequestMapping(value = "ModificarCustomers", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarCustomers(@RequestBody Customer customer) {
        Customer CustomerModificado = this.impl.ModificarCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerModificado);
    }

    @GetMapping
    @RequestMapping(value = "BuscarCustomer/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarCustomer(@PathVariable int id) {
        Customer customer = this.impl.BuscarCustomer(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    @RequestMapping(value = "CrearCustomer", method = RequestMethod.POST)
    public ResponseEntity<?> CrearCustomer(@RequestBody Customer customer) {
        Customer CustomerCreado = this.impl.CrearCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerCreado);
    }

    @DeleteMapping
    @RequestMapping(value = "EliminarCustomers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarCustomers(@PathVariable int id) {
        this.impl.BorrarCustomer(id);
        return ResponseEntity.ok().build();
    }
}
