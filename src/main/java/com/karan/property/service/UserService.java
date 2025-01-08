package com.karan.property.service;


import com.karan.property.entity.Colony;
import com.karan.property.entity.Plot;
import com.karan.property.entity.User;
import com.karan.property.repository.ColonyRepo;
import com.karan.property.repository.PlotRepo;
import com.karan.property.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;


@Service
@Slf4j
public class UserService {
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PlotRepo plotRepo;

    @Autowired
    private ColonyRepo colonyRepo;

    public boolean saveNewUser(User user){
        try{

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
            return true;
        }
        catch (Exception e){
            log.info("error occured for {}" ,user.getUsername());
            return false;
        }

    }

    public void save(User user){
        userRepo.save(user);
    }

    public void addNewCol(Colony colony, String name) {
        for(int i =1;i<=colony.getNumPlots();i++){
            Plot plot = new Plot();
            plot.setPlotNo(i);
            plot.setColonyName(colony.getName());
            plotRepo.save(plot);
            colony.getPlots().add(plot);
        }
        colonyRepo.save(colony); // Save the colony to the colony repository
        Optional<User> user = Optional.ofNullable(userRepo.findByusername(name)); // Find the user by ID
        user.ifPresent(value -> {
            value.getColonies().add(colony); // Add the colony to the user's colonies
            int plots = colony.getNumPlots();

            userRepo.save(value); // Save the updated user to the user repository
        });
    }


}
