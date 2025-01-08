package com.karan.property.controller;



import com.karan.property.entity.Customer;
import com.karan.property.repository.CustomerRepo;
import com.karan.property.service.CustomerService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepo customerRepo;



    @GetMapping("{custName}")
    public ResponseEntity<?>  getAllPlot(@PathVariable String custName){
        Customer customer1 = customerRepo.findBycustName(custName);
        if(customer1!=null){
            return new ResponseEntity<>(customer1.getCustPlots(),HttpStatus.OK);
        }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}
