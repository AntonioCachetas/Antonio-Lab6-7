package org.humber.student.services;

import org.humber.student.domain.Customer;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    boolean deleteCustomer(Long studentId);

    Customer updateCustomer(Customer customer);

    Customer getCustomer(Long studentId);

}
