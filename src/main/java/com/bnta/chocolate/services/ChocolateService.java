package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChocolateService {

    @Autowired
    ChocolateRepository chocolateRepository;

    @Autowired
    EstateRepository estateRepository;

    public Chocolate saveChocolate(ChocolateDTO chocolateDTO){
        Chocolate chocolate = new Chocolate(chocolateDTO.getName(), chocolateDTO.getCocoaPercentage());
        for (long estateId : chocolateDTO.getEstateIds()){
            chocolate.addEstate(estateRepository.findById(estateId).get());
        }
        return chocolateRepository.save(chocolate);
    }

    public Chocolate findChocolate(Long id){
        return chocolateRepository.findById(id).get();
    }

    public List<Chocolate> findAllChocolates(){
        return chocolateRepository.findAll();
    }

    public List<Chocolate> findAllChocolatesOverCocoaPercentage(int percentage){
        return chocolateRepository.findByCocoaPercentageGreaterThan(percentage);
    }

    public Chocolate updateChocolate(ChocolateDTO chocolateDTO, Long id){
        Chocolate chocolateToUpdate = chocolateRepository.findById(id).get();
        chocolateToUpdate.setName(chocolateDTO.getName());
        chocolateToUpdate.setCocoaPercentage(chocolateDTO.getCocoaPercentage());
        chocolateToUpdate.setEstates(new ArrayList<Estate>());

        for (Long estateId : chocolateDTO.getEstateIds()){
            Estate estate = estateRepository.findById(estateId).get();
            chocolateToUpdate.addEstate(estate);
        }
        return chocolateRepository.save(chocolateToUpdate);
    }

}
