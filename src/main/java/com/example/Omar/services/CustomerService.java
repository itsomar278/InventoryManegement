package com.example.Omar.services;

import com.example.Omar.model.Customer;
import com.example.Omar.DataAccess.CustomerRepository;
import com.example.Omar.utils.Exceptions.EmptyResultException;
import com.example.Omar.utils.Exceptions.ResourceExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EmptyResultException("Customer not found"));
    }

    public Customer createCustomer(String name, String phoneNumber) {
        if (customerRepository.existsByPhone(phoneNumber)) {
            throw new ResourceExistsException("Customer with the same phone number already exists");
        }
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(name);
        newCustomer.setPhone(phoneNumber);
        return customerRepository.save(newCustomer);
    }

    public Customer updateCustomer(int id, String name, String phoneNumber) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new EmptyResultException("Customer not found"));

        if (!existingCustomer.getPhone().equals(phoneNumber) &&
                customerRepository.existsByPhone(phoneNumber)) {
            throw new ResourceExistsException("Customer with the same phone number already exists");
        }

        existingCustomer.setFirstName(name);
        existingCustomer.setPhone(phoneNumber);
        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomer(int id) {
        if (!customerRepository.existsById(id)) {
            throw new EmptyResultException("Customer not found");
        }
        customerRepository.deleteById(id);
    }
}
