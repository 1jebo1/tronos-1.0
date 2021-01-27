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

/**
 * A ActivityCalendar.
 */
@Entity
@Table(name = "activity_calendar")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ActivityCalendar extends BaseEntity {

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

    @ManyToOne(targetEntity = ActivityCalendarCategory.class)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties(value = "activityCalendars", allowSetters = true)
    private ActivityCalendarCategory category;

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

    public ActivityCalendar code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public ActivityCalendar description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ActivityCalendarCategory getCategory() {
        return category;
    }

    public ActivityCalendar category(ActivityCalendarCategory activityCalendarCategory) {
        this.category = activityCalendarCategory;
        return this;
    }

    public void setCategory(ActivityCalendarCategory activityCalendarCategory) {
        this.category = activityCalendarCategory;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ActivityCalendar)) {
            return false;
        }
        return id != null && id.equals(((ActivityCalendar) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ActivityCalendar{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
