package com.karan.property.controller;


import com.karan.property.entity.Colony;
import com.karan.property.service.ColonyService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colony")
public class ColonyController {


    @Autowired
    private ColonyService colonyService;

    @Autowired
    AuthenticationManager authenticationManager;



    @GetMapping("/{id}")
    public ResponseEntity<?> getAllplots(@PathVariable ObjectId id){

        return new ResponseEntity<>(colonyService.getAllPlotsColony(id), HttpStatus.OK);
    }
}
