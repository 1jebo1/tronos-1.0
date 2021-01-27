package com.tronos.co.tronos10.rest;

import com.tronos.co.tronos10.domain.AcademicPeriod;
import com.tronos.co.tronos10.repository.AcademicPeriodRepository;
import com.tronos.co.tronos10.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
@Transactional
public class AcademicPeriodResource {

    private final Logger log = LoggerFactory.getLogger(AcademicPeriodResource.class);

    private static final String ENTITY_NAME = "testeofinalAcademicPeriod";

    private String applicationName = "tronos";

    private final AcademicPeriodRepository academicPeriodRepository;

    public AcademicPeriodResource(AcademicPeriodRepository academicPeriodRepository) {
        this.academicPeriodRepository = academicPeriodRepository;
    }


    @PostMapping("/academic-periods")
    public ResponseEntity<AcademicPeriod> createAcademicPeriod(@Valid @RequestBody AcademicPeriod academicPeriod) throws URISyntaxException {
        log.debug("REST request to save AcademicPeriod : {}", academicPeriod);
        if (academicPeriod.getId() != null) {
            throw Utils.throwException("Exception.noSuchElementException2");
        }
        AcademicPeriod result = academicPeriodRepository.save(academicPeriod);
        return ResponseEntity.created(new URI("/api/academic-periods/" + result.getId()))
           // .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    @PutMapping("/academic-periods")
    public ResponseEntity<AcademicPeriod> updateAcademicPeriod(@Valid @RequestBody AcademicPeriod academicPeriod) throws URISyntaxException {
        log.debug("REST request to update AcademicPeriod : {}", academicPeriod);
        if (academicPeriod.getId() == null) {
            throw Utils.throwException("Exception.noSuchElementException");
        }
        AcademicPeriod result = academicPeriodRepository.save(academicPeriod);
        return ResponseEntity.ok()
           // .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, academicPeriod.getId().toString()))
            .body(result);
    }

    @GetMapping("/academic-periods")
    public List<AcademicPeriod> getAllAcademicPeriods() {
        log.debug("REST request to get all AcademicPeriods");
        return academicPeriodRepository.findAll();
    }


    @GetMapping("/academic-periods/{id}")
    public void getAcademicPeriod(@PathVariable Long id) {
        log.debug("REST request to get AcademicPeriod : {}", id);
        Optional<AcademicPeriod> academicPeriod = academicPeriodRepository.findById(id);
    }

    @DeleteMapping("/academic-periods/{id}")
    public ResponseEntity<Void> deleteAcademicPeriod(@PathVariable Long id) {
        log.debug("REST request to delete AcademicPeriod : {}", id);
        academicPeriodRepository.deleteById(id);
        return ResponseEntity.noContent()
               // .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
                .build();
    }
}
