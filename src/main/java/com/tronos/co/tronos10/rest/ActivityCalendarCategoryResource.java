package com.tronos.co.tronos10.rest;

import com.tronos.co.tronos10.service.ActivityCalendarCategoryService;
import com.tronos.co.tronos10.service.dto.ActivityCalendarCategoryDTO;
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
public class ActivityCalendarCategoryResource {

    private final Logger log = LoggerFactory.getLogger(ActivityCalendarCategoryResource.class);

    private static final String ENTITY_NAME = "testeofinalActivityCalendarCategory";

    private String applicationName = "tronos";

    private final ActivityCalendarCategoryService activityCalendarCategoryService;

    public ActivityCalendarCategoryResource(ActivityCalendarCategoryService activityCalendarCategoryService) {
        this.activityCalendarCategoryService = activityCalendarCategoryService;
    }


    @PostMapping("/activity-calendar-categories")
    public ResponseEntity<ActivityCalendarCategoryDTO> createActivityCalendarCategory(@Valid @RequestBody ActivityCalendarCategoryDTO activityCalendarCategoryDTO) throws URISyntaxException {
        log.debug("REST request to save ActivityCalendarCategory : {}", activityCalendarCategoryDTO);
        if (activityCalendarCategoryDTO.getId() != null) {
            throw Utils.throwException("Exception.noSuchElementException3");
        }
        ActivityCalendarCategoryDTO result = activityCalendarCategoryService.save(activityCalendarCategoryDTO);
        return ResponseEntity.created(new URI("/api/activity-calendar-categories/" + result.getId()))
           // .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }


    @PutMapping("/activity-calendar-categories")
    public ResponseEntity<ActivityCalendarCategoryDTO> updateActivityCalendarCategory(@Valid @RequestBody ActivityCalendarCategoryDTO activityCalendarCategoryDTO) throws URISyntaxException {
        log.debug("REST request to update ActivityCalendarCategory : {}", activityCalendarCategoryDTO);
        if (activityCalendarCategoryDTO.getId() == null) {
            throw Utils.throwException("Exception.noSuchElementException");
        }
        ActivityCalendarCategoryDTO result = activityCalendarCategoryService.save(activityCalendarCategoryDTO);
        return ResponseEntity.ok()
          //  .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, activityCalendarCategoryDTO.getId().toString()))
            .body(result);
    }

    @GetMapping("/activity-calendar-categories")
    public ResponseEntity<List<ActivityCalendarCategoryDTO>> getAllActivityCalendarCategories(Pageable pageable) {
        log.debug("REST request to get a page of ActivityCalendarCategories");
        Page<ActivityCalendarCategoryDTO> page = activityCalendarCategoryService.findAll(pageable);
        return ResponseEntity.ok()
                .body(page.getContent());
    }

    @GetMapping("/activity-calendar-categories/{id}")
    public void getActivityCalendarCategory(@PathVariable Long id) {
        log.debug("REST request to get ActivityCalendarCategory : {}", id);
        Optional<ActivityCalendarCategoryDTO> activityCalendarCategoryDTO = activityCalendarCategoryService.findOne(id);
    }


    @DeleteMapping("/activity-calendar-categories/{id}")
    public ResponseEntity<Void> deleteActivityCalendarCategory(@PathVariable Long id) {
        log.debug("REST request to delete ActivityCalendarCategory : {}", id);
        activityCalendarCategoryService.delete(id);
        return ResponseEntity.noContent()
                //.headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
                .build();
    }
}
