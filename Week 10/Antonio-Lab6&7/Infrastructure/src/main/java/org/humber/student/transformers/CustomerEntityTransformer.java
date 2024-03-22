package org.humber.student.transformers;

import org.humber.student.domain.Customer;
import org.humber.student.repositories.entities.CustomerEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class CustomerEntityTransformer {

    private CustomerEntityTransformer() {
    }

    public static CustomerEntity transformToCustomerEntity(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(customer.getCustomer_id());
        customerEntity.setName(customer.getName());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setPhone(customer.getPhone());
        customerEntity.setPostal_code(customer.getPostal_code());
        customerEntity.setCountry(customer.getCountry());
        return customerEntity;
    }

    public static Customer transformToCustomer(CustomerEntity customerEntity) {
        return Customer.builder()
                .customer_id(customerEntity.getCustomerId())
                .name(customerEntity.getName())
                .email(customerEntity.getEmail())
                .phone(customerEntity.getPhone())
                .postal_code(customerEntity.getPostal_code())
                .country(customerEntity.getCountry())
                .build();
    }

    public static List<Customer> transformToCustomers(List<CustomerEntity> entities) {
        return entities.stream()
                .map(CustomerEntityTransformer::transformToCustomer)
                .collect(Collectors.toList());
    }
}
