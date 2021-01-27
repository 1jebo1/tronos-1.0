package com.tronos.co.tronos10.repository;

import com.tronos.co.tronos10.domain.AcademicPeriod;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AcademicPeriod entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AcademicPeriodRepository extends JpaRepository<AcademicPeriod, Long> {
}
