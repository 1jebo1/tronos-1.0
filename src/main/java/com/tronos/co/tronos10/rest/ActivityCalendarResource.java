package com.tronos.co.tronos10.rest;

import com.tronos.co.tronos10.service.ActivityCalendarService;
import com.tronos.co.tronos10.service.dto.ActivityCalendarDTO;
import com.tronos.co.tronos10.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ActivityCalendarResource {

    private final Logger log = LoggerFactory.getLogger(ActivityCalendarResource.class);

    private static final String ENTITY_NAME = "testeofinalActivityCalendar";

    private String applicationName = "tronos";

    private final ActivityCalendarService activityCalendarService;

    public ActivityCalendarResource(ActivityCalendarService activityCalendarService) {
        this.activityCalendarService = activityCalendarService;
    }

    @PostMapping("/activity-calendars")
    public ResponseEntity<ActivityCalendarDTO> createActivityCalendar(@Valid @RequestBody ActivityCalendarDTO activityCalendarDTO) throws URISyntaxException {
        log.debug("REST request to save ActivityCalendar : {}", activityCalendarDTO);
        if (activityCalendarDTO.getId() != null) {
            throw Utils.throwException("Exception.noSuchElementException5");
        }
        ActivityCalendarDTO result = activityCalendarService.save(activityCalendarDTO);
        return ResponseEntity.created(new URI("/api/activity-calendars/" + result.getId()))
            .body(result);
    }

    @PutMapping("/activity-calendars")
    public ResponseEntity<ActivityCalendarDTO> updateActivityCalendar(@Valid @RequestBody ActivityCalendarDTO activityCalendarDTO) throws URISyntaxException {
        log.debug("REST request to update ActivityCalendar : {}", activityCalendarDTO);
        if (activityCalendarDTO.getId() == null) {
            throw Utils.throwException("Exception.noSuchElementException");
        }
        ActivityCalendarDTO result = activityCalendarService.save(activityCalendarDTO);
        return ResponseEntity.ok()
            .body(result);
    }

    @GetMapping("/activity-calendars")
    public ResponseEntity<List<ActivityCalendarDTO>> getAllActivityCalendars(Pageable pageable) {
        log.debug("REST request to get a page of ActivityCalendars");
        Page<ActivityCalendarDTO> page = activityCalendarService.findAll(pageable);
        return ResponseEntity.ok()
                .body(page.getContent());
    }


    @GetMapping("/activity-calendars/{id}")
    public void getActivityCalendar(@PathVariable Long id) {
        log.debug("REST request to get ActivityCalendar : {}", id);
        Optional<ActivityCalendarDTO> activityCalendarDTO = activityCalendarService.findOne(id);
    }

    @DeleteMapping("/activity-calendars/{id}")
    public ResponseEntity<Void> deleteActivityCalendar(@PathVariable Long id) {
        log.debug("REST request to delete ActivityCalendar : {}", id);
        activityCalendarService.delete(id);
        return ResponseEntity.noContent()
                .build();
    }
}
