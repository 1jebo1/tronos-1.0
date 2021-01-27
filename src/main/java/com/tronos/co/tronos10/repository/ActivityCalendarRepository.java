package com.tronos.co.tronos10.repository;

import com.tronos.co.tronos10.domain.ActivityCalendar;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ActivityCalendar entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ActivityCalendarRepository extends JpaRepository<ActivityCalendar, Long> {
}
