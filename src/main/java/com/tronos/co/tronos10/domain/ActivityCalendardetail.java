package com.tronos.co.tronos10.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "activity_calendardetail")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ActivityCalendardetail extends BaseEntity {

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

    @ManyToOne
    @JsonIgnoreProperties(value = "activityCalendardetails", allowSetters = true)
    private com.tronos.co.tronos10.domain.ActivityCalendar activity;

    @ManyToOne
    @JsonIgnoreProperties(value = "activityCalendardetails", allowSetters = true)
    private com.tronos.co.tronos10.domain.AcademicCalendar calendar;

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

    public ActivityCalendardetail code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public ActivityCalendardetail description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public com.tronos.co.tronos10.domain.ActivityCalendar getActivity() {
        return activity;
    }

    public ActivityCalendardetail activity(com.tronos.co.tronos10.domain.ActivityCalendar activityCalendar) {
        this.activity = activityCalendar;
        return this;
    }

    public void setActivity(com.tronos.co.tronos10.domain.ActivityCalendar activityCalendar) {
        this.activity = activityCalendar;
    }

    public com.tronos.co.tronos10.domain.AcademicCalendar getCalendar() {
        return calendar;
    }

    public ActivityCalendardetail calendar(com.tronos.co.tronos10.domain.AcademicCalendar academicCalendar) {
        this.calendar = academicCalendar;
        return this;
    }

    public void setCalendar(com.tronos.co.tronos10.domain.AcademicCalendar academicCalendar) {
        this.calendar = academicCalendar;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ActivityCalendardetail)) {
            return false;
        }
        return id != null && id.equals(((ActivityCalendardetail) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ActivityCalendardetail{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
