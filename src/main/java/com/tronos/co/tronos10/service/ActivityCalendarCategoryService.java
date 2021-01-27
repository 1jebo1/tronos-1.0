package com.tronos.co.tronos10.service;

import com.tronos.co.tronos10.service.dto.ActivityCalendarCategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ActivityCalendarCategoryService {

    ActivityCalendarCategoryDTO save(ActivityCalendarCategoryDTO activityCalendarCategoryDTO);

    Page<ActivityCalendarCategoryDTO> findAll(Pageable pageable);

    Optional<ActivityCalendarCategoryDTO> findOne(Long id);

    void delete(Long id);
}
