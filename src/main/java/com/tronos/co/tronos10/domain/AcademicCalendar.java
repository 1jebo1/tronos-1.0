package com.tronos.co.tronos10.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A AcademicCalendar.
 */
@Entity
@Table(name = "academic_calendar")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AcademicCalendar extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Size(min = 4, max = 100)
    @Column(name = "code", length = 100, nullable = false, unique = true)
    private String code;

    @NotNull
    @Size(min = 4, max = 100)
    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @NotNull
    @Size(min = 4, max = 255)
    @Column(name = "agreement", length = 255, nullable = false)
    private String agreement;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne(targetEntity = AcademicPeriod.class)
    @JsonIgnoreProperties(value = "academicCalendars", allowSetters = true)
    @JoinColumn(name = "period_id")
    private AcademicPeriod period;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public AcademicCalendar code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public AcademicCalendar description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAgreement() {
        return agreement;
    }

    public AcademicCalendar agreement(String agreement) {
        this.agreement = agreement;
        return this;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public LocalDate getDate() {
        return date;
    }

    public AcademicCalendar date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AcademicPeriod getPeriod() {
        return period;
    }

    public AcademicCalendar period(AcademicPeriod academicPeriod) {
        this.period = academicPeriod;
        return this;
    }

    public void setPeriod(AcademicPeriod academicPeriod) {
        this.period = academicPeriod;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AcademicCalendar)) {
            return false;
        }
        return id != null && id.equals(((AcademicCalendar) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AcademicCalendar{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", agreement='" + getAgreement() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }
}
