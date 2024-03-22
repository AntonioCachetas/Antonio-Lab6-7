package org.humber.student.services;

import org.humber.student.domain.Customer;

import java.util.List;

public interface CustomerJPAService {

    Customer getCustomerById(Long studentId);

    List<Customer> getAllCustomer();

    Customer saveCustomer(Customer customer);

}
