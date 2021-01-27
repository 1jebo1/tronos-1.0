package com.tronos.co.tronos10.service.impl;

import com.tronos.co.tronos10.domain.ActivityCalendarCategory;
import com.tronos.co.tronos10.repository.ActivityCalendarCategoryRepository;
import com.tronos.co.tronos10.service.ActivityCalendarCategoryService;
import com.tronos.co.tronos10.service.dto.ActivityCalendarCategoryDTO;
import com.tronos.co.tronos10.service.mapper.ActivityCalendarCategoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ActivityCalendarCategory}.
 */
@Service
@Transactional
public class ActivityCalendarCategoryServiceImpl implements ActivityCalendarCategoryService {

    private final Logger log = LoggerFactory.getLogger(ActivityCalendarCategoryServiceImpl.class);

    private final ActivityCalendarCategoryRepository activityCalendarCategoryRepository;

    private final ActivityCalendarCategoryMapper activityCalendarCategoryMapper;

    public ActivityCalendarCategoryServiceImpl(ActivityCalendarCategoryRepository activityCalendarCategoryRepository, ActivityCalendarCategoryMapper activityCalendarCategoryMapper) {
        this.activityCalendarCategoryRepository = activityCalendarCategoryRepository;
        this.activityCalendarCategoryMapper = activityCalendarCategoryMapper;
    }

    @Override
    public ActivityCalendarCategoryDTO save(ActivityCalendarCategoryDTO activityCalendarCategoryDTO) {
        log.debug("Request to save ActivityCalendarCategory : {}", activityCalendarCategoryDTO);
        ActivityCalendarCategory activityCalendarCategory = activityCalendarCategoryMapper.toEntity(activityCalendarCategoryDTO);
        activityCalendarCategory = activityCalendarCategoryRepository.save(activityCalendarCategory);
        return activityCalendarCategoryMapper.toDto(activityCalendarCategory);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ActivityCalendarCategoryDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ActivityCalendarCategories");
        return activityCalendarCategoryRepository.findAll(pageable)
            .map(activityCalendarCategoryMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ActivityCalendarCategoryDTO> findOne(Long id) {
        log.debug("Request to get ActivityCalendarCategory : {}", id);
        return activityCalendarCategoryRepository.findById(id)
            .map(activityCalendarCategoryMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ActivityCalendarCategory : {}", id);
        activityCalendarCategoryRepository.deleteById(id);
    }
}
