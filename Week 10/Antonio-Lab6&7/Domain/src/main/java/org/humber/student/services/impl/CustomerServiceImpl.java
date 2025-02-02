package org.humber.student.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.humber.student.domain.Customer;
import org.humber.student.exceptions.ErrorCode;
import org.humber.student.exceptions.CustomerValidationException;
import org.humber.student.services.CustomerJPAService;
import org.humber.student.services.CustomerService;
import org.humber.student.services.CustomerValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerJPAService customerJpaService;
    private final List<CustomerValidationService> validationServices;

    @Autowired
    public CustomerServiceImpl(CustomerJPAService customerJpaService, List<CustomerValidationService> validationService) {
        this.customerJpaService = customerJpaService;
        this.validationServices = validationService;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        log.info("In method createCustomer, validating customer= {}", customer);
        for (CustomerValidationService validationService : validationServices) {
            if (validationService instanceof CustomerIdValidation) {
                log.info("Skipping CustomerIdValidation for new Customer");
                continue;
            }
            validationService.validateCustomer(customer);
        }
        log.info("Saving student");
        return customerJpaService.saveCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(Long customerId) {
        System.out.println("Deleting customer");
        Customer customer = customerJpaService.getCustomerById(customerId);
        return customer != null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        //TODO: Implement update customer
        System.out.println("Updating customer");
        return null;
    }

    @Override
    public Customer getCustomer(Long customerId) {
        System.out.println("Getting customer");
        if (customerId == null) {
            System.err.println("Customer id is null");
            throw new CustomerValidationException(ErrorCode.INVALID_CUSTOMER_ID);
        }
        return customerJpaService.getCustomerById(customerId);
    }
}
