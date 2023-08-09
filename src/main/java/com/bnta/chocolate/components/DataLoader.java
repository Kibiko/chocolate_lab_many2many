package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ChocolateRepository chocolateRepository;

    @Autowired
    EstateRepository estateRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // RABOT ESTATE
        Estate rabotEstate = new Estate("Rabot Estate", "St Lucia");
        estateRepository.save(rabotEstate);

        Chocolate saltedDark = new Chocolate("Salted Dark", 70);
        saltedDark.addEstate(rabotEstate);
        chocolateRepository.save(saltedDark);

        Chocolate supermilkHazelnut = new Chocolate("Supermilk Hazelnut", 40);
        supermilkHazelnut.addEstate(rabotEstate);
        chocolateRepository.save(supermilkHazelnut);

        // HACIENDA ZOLITA
        Estate haciendaZolita = new Estate("Hacienda Zolita", "Ecuador");
        estateRepository.save(haciendaZolita);

        Chocolate ecuadorDark = new Chocolate("Ecuador Dark", 72);
        ecuadorDark.addEstate(haciendaZolita);
        chocolateRepository.save(ecuadorDark);

        Chocolate mintyLove = new Chocolate("Minty Love", 72);
        mintyLove.addEstate(haciendaZolita);
        chocolateRepository.save(mintyLove);

        // DIVINE
        Estate kuapaKokoo = new Estate("Kuapa Kokoo", "Ghana");
        estateRepository.save(kuapaKokoo);

        Chocolate pinkSalt = new Chocolate("Dark Pink Himalayan Salt", 60);
        pinkSalt.addEstate(kuapaKokoo);
        chocolateRepository.save(pinkSalt);

        // MULTIPLE
        Chocolate caramelLux = new Chocolate("Caramel Deluxe", 50);
        caramelLux.addEstate(haciendaZolita);
        caramelLux.addEstate(kuapaKokoo);
        caramelLux.addEstate(rabotEstate);
        chocolateRepository.save(caramelLux);

        Chocolate toffeeTruffle = new Chocolate("Toffee Truffle",80);
        toffeeTruffle.addEstate(haciendaZolita);
        toffeeTruffle.addEstate(kuapaKokoo);
        chocolateRepository.save(toffeeTruffle);
    }
}
