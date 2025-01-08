package com.karan.property.service;


import com.karan.property.entity.Colony;
import com.karan.property.entity.Plot;
import com.karan.property.entity.User;
import com.karan.property.repository.ColonyRepo;
import com.karan.property.repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColonyService {

    @Autowired
    private ColonyRepo colonyRepo;

    @Autowired
    private UserRepo userRepo;

    public void saveColony(Colony colony,String name){
        colonyRepo.save(colony);
        Optional<User> user = Optional.ofNullable(userRepo.findByusername(name));
        if(user.isPresent()){
            user.get().getColonies().add(colony);
            userRepo.save(user.get());
        }

    }

    public Colony getByName(String colonyName){
        return colonyRepo.findByname(colonyName);
    }

    public List<Plot> getAllPlotsColony(ObjectId id){
        return colonyRepo.findById(id).get().getPlots();
    }

    public List<Colony> getAllColoniesOfUser(User user){
        User user1 = userRepo.findByusername(user.getUsername());
        return user1.getColonies();
    }
}
