package com.tronos.co.tronos10.service.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

public class AcademicCalendarDTO implements Serializable {
    
    private Long id;

    @NotNull
    @Size(min = 4, max = 100)
    private String code;

    @NotNull
    @Size(min = 4, max = 100)
    private String description;

    @NotNull
    @Size(min = 4, max = 255)
    private String agreement;

    @NotNull
    private LocalDate date;


    private Long periodId;
    
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

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long academicPeriodId) {
        this.periodId = academicPeriodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AcademicCalendarDTO)) {
            return false;
        }

        return id != null && id.equals(((AcademicCalendarDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AcademicCalendarDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", agreement='" + getAgreement() + "'" +
            ", date='" + getDate() + "'" +
            ", periodId=" + getPeriodId() +
            "}";
    }
}
