package com.tronos.co.tronos10.repository;

import com.tronos.co.tronos10.domain.ActivityCalendarCategory;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ActivityCalendarCategory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ActivityCalendarCategoryRepository extends JpaRepository<ActivityCalendarCategory, Long> {
}
