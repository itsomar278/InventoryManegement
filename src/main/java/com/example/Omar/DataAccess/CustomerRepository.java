package com.example.Omar.DataAccess;

import com.example.Omar.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByPhone(String phoneNumber);
}
