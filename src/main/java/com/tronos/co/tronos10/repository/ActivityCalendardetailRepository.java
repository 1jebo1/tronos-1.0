package com.tronos.co.tronos10.repository;

import com.tronos.co.tronos10.domain.ActivityCalendardetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ActivityCalendardetail entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ActivityCalendardetailRepository extends JpaRepository<ActivityCalendardetail, Long> {
}
