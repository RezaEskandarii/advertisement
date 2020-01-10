package com.tutorialpro.tutorialpro.repository;

import com.tutorialpro.tutorialpro.entities.HouseAd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseAdRepository extends JpaRepository<HouseAd, Integer> {
}
