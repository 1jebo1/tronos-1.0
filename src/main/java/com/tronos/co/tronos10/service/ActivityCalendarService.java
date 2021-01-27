package com.tronos.co.tronos10.service;

import com.tronos.co.tronos10.service.dto.ActivityCalendarDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ActivityCalendarService {

    ActivityCalendarDTO save(ActivityCalendarDTO activityCalendarDTO);

    Page<ActivityCalendarDTO> findAll(Pageable pageable);

    Optional<ActivityCalendarDTO> findOne(Long id);

    void delete(Long id);
}
