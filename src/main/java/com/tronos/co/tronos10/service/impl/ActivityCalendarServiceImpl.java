package com.tronos.co.tronos10.service.impl;

import com.tronos.co.tronos10.domain.ActivityCalendar;
import com.tronos.co.tronos10.repository.ActivityCalendarRepository;
import com.tronos.co.tronos10.service.ActivityCalendarService;
import com.tronos.co.tronos10.service.dto.ActivityCalendarDTO;
import com.tronos.co.tronos10.service.mapper.ActivityCalendarMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class ActivityCalendarServiceImpl implements ActivityCalendarService {

    private final Logger log = LoggerFactory.getLogger(ActivityCalendarServiceImpl.class);

    private final ActivityCalendarRepository activityCalendarRepository;

    private final ActivityCalendarMapper activityCalendarMapper;

    public ActivityCalendarServiceImpl(ActivityCalendarRepository activityCalendarRepository, ActivityCalendarMapper activityCalendarMapper) {
        this.activityCalendarRepository = activityCalendarRepository;
        this.activityCalendarMapper = activityCalendarMapper;
    }

    @Override
    public ActivityCalendarDTO save(ActivityCalendarDTO activityCalendarDTO) {
        log.debug("Request to save ActivityCalendar : {}", activityCalendarDTO);
        ActivityCalendar activityCalendar = activityCalendarMapper.toEntity(activityCalendarDTO);
        activityCalendar = activityCalendarRepository.save(activityCalendar);
        return activityCalendarMapper.toDto(activityCalendar);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ActivityCalendarDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ActivityCalendars");
        return activityCalendarRepository.findAll(pageable)
            .map(activityCalendarMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ActivityCalendarDTO> findOne(Long id) {
        log.debug("Request to get ActivityCalendar : {}", id);
        return activityCalendarRepository.findById(id)
            .map(activityCalendarMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ActivityCalendar : {}", id);
        activityCalendarRepository.deleteById(id);
    }
}
