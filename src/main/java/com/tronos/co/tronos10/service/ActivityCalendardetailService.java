package com.tronos.co.tronos10.service;

import com.tronos.co.tronos10.service.dto.ActivityCalendardetailDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ActivityCalendardetailService {

    ActivityCalendardetailDTO save(ActivityCalendardetailDTO activityCalendardetailDTO);

    Page<ActivityCalendardetailDTO> findAll(Pageable pageable);

    Optional<ActivityCalendardetailDTO> findOne(Long id);

    void delete(Long id);
}
