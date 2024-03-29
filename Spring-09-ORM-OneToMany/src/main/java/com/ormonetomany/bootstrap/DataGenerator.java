package com.ormonetomany.bootstrap;

import com.ormonetomany.entity.Address;
import com.ormonetomany.entity.Person;
import com.ormonetomany.repository.AddressRepository;
import com.ormonetomany.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {

        Person p1 = new Person("Mike", "Smith");
        Person p2 = new Person("Ozzy", "Kmith");
        Person p3 = new Person("Tedd", "Bbith");

        Address a1 = new Address("King St", "22042");
        Address a2 = new Address("Elm St", "22102");
        Address a3 = new Address("Java St", "22036");


        personRepository.save(p1);

        a1.setPerson(p1);
        a2.setPerson(p1);
        a3.setPerson(p1);

        addressRepository.save(a1);
        addressRepository.save(a2);
        addressRepository.save(a3);
    }
}
