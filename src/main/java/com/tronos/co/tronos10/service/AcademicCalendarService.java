package com.tronos.co.tronos10.service;

import com.tronos.co.tronos10.service.dto.AcademicCalendarDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AcademicCalendarService {

    AcademicCalendarDTO save(AcademicCalendarDTO academicCalendarDTO);

    Page<AcademicCalendarDTO> findAll(Pageable pageable);

    Optional<AcademicCalendarDTO> findOne(Long id);

    void delete(Long id);
}
