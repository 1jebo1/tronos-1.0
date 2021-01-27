package com.tronos.co.tronos10.rest;

import com.tronos.co.tronos10.service.AcademicCalendarService;
import com.tronos.co.tronos10.service.dto.AcademicCalendarDTO;
import com.tronos.co.tronos10.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class AcademicCalendarResource {

    private static final String ENTITY_NAME = "testeofinalActivityCalendarCategory";
    private final Logger log = LoggerFactory.getLogger(AcademicCalendarResource.class);
    private final AcademicCalendarService academicCalendarService;
    private final String applicationName = "tronos";

    public AcademicCalendarResource(AcademicCalendarService academicCalendarService) {
        this.academicCalendarService = academicCalendarService;
    }

    @PostMapping("/academic-calendars")
    public ResponseEntity<AcademicCalendarDTO> createAcademicCalendar(@Valid @RequestBody AcademicCalendarDTO academicCalendarDTO) throws URISyntaxException {
        log.debug("REST request to save AcademicCalendar : {}", academicCalendarDTO);
        if (academicCalendarDTO.getId() != null) {
            throw Utils.throwException("Exception.noSuchElementException1");
        }
        AcademicCalendarDTO result = academicCalendarService.save(academicCalendarDTO);
        return ResponseEntity.created(new URI("/api/activity-calendar-categories/" + result.getId()))
               // .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    @PutMapping("/academic-calendars")
    public ResponseEntity<AcademicCalendarDTO> updateAcademicCalendar(@Valid @RequestBody AcademicCalendarDTO academicCalendarDTO) throws URISyntaxException {
        log.debug("REST request to update AcademicCalendar : {}", academicCalendarDTO);
        if (academicCalendarDTO.getId() == null) {
            throw Utils.throwException("Exception.noSuchElementException");
        }
        AcademicCalendarDTO result = academicCalendarService.save(academicCalendarDTO);
        return ResponseEntity.ok()
              //  .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, activityCalendarCategoryDTO.getId().toString()))
              .body(result);
    }

    @GetMapping("/academic-calendars")
    public ResponseEntity<List<AcademicCalendarDTO>> getAllAcademicCalendars(Pageable pageable) {
        log.debug("REST request to get a page of AcademicCalendars");
        Page<AcademicCalendarDTO> page = academicCalendarService.findAll(pageable);
        return ResponseEntity.ok()
                .body(page.getContent());
    }

    @GetMapping("/academic-calendars/{id}")
    public void getAcademicCalendar(@PathVariable Long id) {
        log.debug("REST request to get AcademicCalendar : {}", id);
        Optional<AcademicCalendarDTO> academicCalendarDTO = academicCalendarService.findOne(id);
    }

    @DeleteMapping("/academic-calendars/{id}")
    public ResponseEntity<Void> deleteAcademicCalendar(@PathVariable Long id) {
        log.debug("REST request to delete AcademicCalendar : {}", id);
        academicCalendarService.delete(id);
        return ResponseEntity.noContent()
                //.headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
                .build();
    }
}
