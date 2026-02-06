package com.dantruong.custommer_store_procedure.service;

import com.dantruong.custommer_store_procedure.connection.CustomerRepo;
import com.dantruong.custommer_store_procedure.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public void processing(String name, String email){
        customerRepo.addCustomer(name,email);
    }

    public List<Customer> showList(){
      return   customerRepo.findAll();
    }
}
