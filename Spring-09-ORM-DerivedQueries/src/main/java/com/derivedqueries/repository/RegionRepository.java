package com.derivedqueries.repository;

import com.derivedqueries.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

    // Display all the regions in Canada
    List<Region> findByCountry(String country);

    // Display all regions in Canada, without duplicates
    List<Region> findDistinctByCountry(String country);

    // Display all regions with country name includes 'United'
    List<Region> findByCountryContaining(String country);

    // Display all regions with country name includes 'United' in order
    List<Region> findByCountryContainingOrderByCountry(String country);
}
