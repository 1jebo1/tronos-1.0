package com.tronos.co.tronos10.rest;

import com.tronos.co.tronos10.service.ActivityCalendardetailService;
import com.tronos.co.tronos10.service.dto.ActivityCalendardetailDTO;
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
public class ActivityCalendardetailResource {

    private final Logger log = LoggerFactory.getLogger(ActivityCalendardetailResource.class);

    private static final String ENTITY_NAME = "testeofinalActivityCalendardetail";

    private String applicationName = "tronos";

    private final ActivityCalendardetailService activityCalendardetailService;

    public ActivityCalendardetailResource(ActivityCalendardetailService activityCalendardetailService) {
        this.activityCalendardetailService = activityCalendardetailService;
    }


    @PostMapping("/activity-calendardetails")
    public ResponseEntity<ActivityCalendardetailDTO> createActivityCalendardetail(@Valid @RequestBody ActivityCalendardetailDTO activityCalendardetailDTO) throws URISyntaxException {
        log.debug("REST request to save ActivityCalendardetail : {}", activityCalendardetailDTO);
        if (activityCalendardetailDTO.getId() != null) {
            throw Utils.throwException("Exception.noSuchElementException4");
        }
        ActivityCalendardetailDTO result = activityCalendardetailService.save(activityCalendardetailDTO);
        return ResponseEntity.created(new URI("/api/activity-calendardetails/" + result.getId()))
            .body(result);
    }

    @PutMapping("/activity-calendardetails")
    public ResponseEntity<ActivityCalendardetailDTO> updateActivityCalendardetail(@Valid @RequestBody ActivityCalendardetailDTO activityCalendardetailDTO) throws URISyntaxException {
        log.debug("REST request to update ActivityCalendardetail : {}", activityCalendardetailDTO);
        if (activityCalendardetailDTO.getId() == null) {
            throw Utils.throwException("Exception.noSuchElementException");
        }
        ActivityCalendardetailDTO result = activityCalendardetailService.save(activityCalendardetailDTO);
        return ResponseEntity.ok()
            .body(result);
    }

    @GetMapping("/activity-calendardetails")
    public ResponseEntity<List<ActivityCalendardetailDTO>> getAllActivityCalendardetails(Pageable pageable) {
        log.debug("REST request to get a page of ActivityCalendardetails");
        Page<ActivityCalendardetailDTO> page = activityCalendardetailService.findAll(pageable);
        return ResponseEntity.ok()
               .body(page.getContent());
    }

    @GetMapping("/activity-calendardetails/{id}")
    public void getActivityCalendardetail(@PathVariable Long id) {
        log.debug("REST request to get ActivityCalendardetail : {}", id);
        Optional<ActivityCalendardetailDTO> activityCalendardetailDTO = activityCalendardetailService.findOne(id);
    }

    @DeleteMapping("/activity-calendardetails/{id}")
    public ResponseEntity<Void> deleteActivityCalendardetail(@PathVariable Long id) {
        log.debug("REST request to delete ActivityCalendardetail : {}", id);
        activityCalendardetailService.delete(id);
        return ResponseEntity.noContent()
                .build();
    }
}
