package com.derivedqueries;

import com.derivedqueries.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DerivedqueriesApplication {


    @Autowired
    RegionRepository regionRepository;

    public static void main(String[] args) {
        SpringApplication.run(DerivedqueriesApplication.class, args);
    }

    @PostConstruct
    public void testRegions() {
        System.out.println();
        System.out.println("------------------ REGION STARTS -----------------");
        System.out.println("findByCountry : " + regionRepository.findByCountry("Canada"));
        System.out.println();
        System.out.println("findDistinctByCountry : " + regionRepository.findByCountry("Canada"));
        System.out.println();
        System.out.println("findByCountryContaining : " + regionRepository.findByCountryContaining("United"));
        System.out.println();
        System.out.println("findByCountryContainingOrderByCountry : " + regionRepository.findByCountryContainingOrderByCountry("United"));
        System.out.println();
        System.out.println("findTopBy2ByCountry : " + regionRepository.findTop2ByCountry("Canada"));
        System.out.println("------------------ REGION ENDS -----------------");
        System.out.println();
    }

}
