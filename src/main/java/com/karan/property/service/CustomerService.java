package com.karan.property.service;


import com.karan.property.entity.Customer;
import com.karan.property.entity.Plot;
import com.karan.property.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    @Autowired
    private CustomerRepo customerRepo;
    public void addNerCustomer(Customer customer){
        customerRepo.save(customer);
    }

    public Customer addPlot(Plot plot, String name) {
        Customer toAdd = customerRepo.findBycustName(name);
        if(toAdd==null){
            Customer customer = new Customer();
            customer.getCustPlots().add(plot);
            customer.setCustName(name);
            customer.setAddress(plot.getCustAdd());
            customer.setAadharNum(plot.getCustAadhar());
            customer.setPhNum(plot.getCustPhoneNum());
            customerRepo.save(customer);
            return customer;
        }
        else {
            toAdd.getCustPlots().add(plot);
            return toAdd;
        }
    }

    public List<Customer> getAllCustomers(){
        return  customerRepo.findAll();
    }
}
