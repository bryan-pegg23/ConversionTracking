package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.HitsPerDay;

public interface ViewRepository extends JpaRepository<HitsPerDay, Long>{


}