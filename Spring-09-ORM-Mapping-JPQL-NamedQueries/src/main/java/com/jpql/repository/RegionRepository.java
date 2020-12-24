package com.jpql.repository;

import com.jpql.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
}
