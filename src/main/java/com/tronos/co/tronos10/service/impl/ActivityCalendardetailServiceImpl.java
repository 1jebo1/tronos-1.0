package com.tronos.co.tronos10.service.impl;

import com.tronos.co.tronos10.domain.ActivityCalendardetail;
import com.tronos.co.tronos10.repository.ActivityCalendardetailRepository;
import com.tronos.co.tronos10.service.ActivityCalendardetailService;
import com.tronos.co.tronos10.service.dto.ActivityCalendardetailDTO;
import com.tronos.co.tronos10.service.mapper.ActivityCalendardetailMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ActivityCalendardetail}.
 */
@Service
@Transactional
public class ActivityCalendardetailServiceImpl implements ActivityCalendardetailService {

    private final Logger log = LoggerFactory.getLogger(ActivityCalendardetailServiceImpl.class);

    private final ActivityCalendardetailRepository activityCalendardetailRepository;

    private final ActivityCalendardetailMapper activityCalendardetailMapper;

    public ActivityCalendardetailServiceImpl(ActivityCalendardetailRepository activityCalendardetailRepository, ActivityCalendardetailMapper activityCalendardetailMapper) {
        this.activityCalendardetailRepository = activityCalendardetailRepository;
        this.activityCalendardetailMapper = activityCalendardetailMapper;
    }

    @Override
    public ActivityCalendardetailDTO save(ActivityCalendardetailDTO activityCalendardetailDTO) {
        log.debug("Request to save ActivityCalendardetail : {}", activityCalendardetailDTO);
        ActivityCalendardetail activityCalendardetail = activityCalendardetailMapper.toEntity(activityCalendardetailDTO);
        activityCalendardetail = activityCalendardetailRepository.save(activityCalendardetail);
        return activityCalendardetailMapper.toDto(activityCalendardetail);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ActivityCalendardetailDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ActivityCalendardetails");
        return activityCalendardetailRepository.findAll(pageable)
            .map(activityCalendardetailMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ActivityCalendardetailDTO> findOne(Long id) {
        log.debug("Request to get ActivityCalendardetail : {}", id);
        return activityCalendardetailRepository.findById(id)
            .map(activityCalendardetailMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ActivityCalendardetail : {}", id);
        activityCalendardetailRepository.deleteById(id);
    }
}
