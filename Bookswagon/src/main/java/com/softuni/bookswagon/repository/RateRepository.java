package com.softuni.bookswagon.repository;

import com.softuni.bookswagon.model.entity.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<RateEntity, Long> {
    void deleteByBook_Id(Long id);
}