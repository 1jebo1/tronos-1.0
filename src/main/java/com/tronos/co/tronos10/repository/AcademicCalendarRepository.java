package com.tronos.co.tronos10.repository;

import com.tronos.co.tronos10.domain.AcademicCalendar;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AcademicCalendar entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AcademicCalendarRepository extends JpaRepository<AcademicCalendar, Long> {
}
