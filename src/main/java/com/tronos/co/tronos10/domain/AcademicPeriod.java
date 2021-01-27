package com.tronos.co.tronos10.domain;

import com.tronos.co.tronos10.domain.enumeration.PeriodicityType;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A AcademicPeriod.
 */
@Entity
@Table(name = "academic_period")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AcademicPeriod extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Size(min = 4, max = 100)
    @Column(name = "code",length = 100, nullable = false, unique = true)
    private String code;

    @NotNull
    @Size(min = 4, max = 100)
    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "periodicity")
    private PeriodicityType periodicity;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "period", nullable = false)
    private Integer period;

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

    public AcademicPeriod code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public AcademicPeriod description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PeriodicityType getPeriodicity() {
        return periodicity;
    }

    public AcademicPeriod periodicity(PeriodicityType periodicity) {
        this.periodicity = periodicity;
        return this;
    }

    public void setPeriodicity(PeriodicityType periodicity) {
        this.periodicity = periodicity;
    }

    public Integer getYear() {
        return year;
    }

    public AcademicPeriod year(Integer year) {
        this.year = year;
        return this;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPeriod() {
        return period;
    }

    public AcademicPeriod period(Integer period) {
        this.period = period;
        return this;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AcademicPeriod)) {
            return false;
        }
        return id != null && id.equals(((AcademicPeriod) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AcademicPeriod{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", periodicity='" + getPeriodicity() + "'" +
            ", year=" + getYear() +
            ", period=" + getPeriod() +
            "}";
    }
}
