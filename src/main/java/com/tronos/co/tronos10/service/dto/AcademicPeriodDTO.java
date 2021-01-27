package com.tronos.co.tronos10.service.dto;

import com.tronos.co.tronos10.domain.enumeration.PeriodicityType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class AcademicPeriodDTO implements Serializable {
    
    private Long id;

    @NotNull
    @Size(min = 4, max = 100)
    private String code;

    @NotNull
    @Size(min = 4, max = 100)
    private String description;

    @NotNull
    private Integer year;

    @NotNull
    private Integer period;

    @NotNull
    private PeriodicityType periodicity;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public PeriodicityType getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(PeriodicityType periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AcademicPeriodDTO)) {
            return false;
        }

        return id != null && id.equals(((AcademicPeriodDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AcademicPeriodDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", year=" + getYear() +
            ", period=" + getPeriod() +
            ", periodicity='" + getPeriodicity() + "'" +
            "}";
    }
}
