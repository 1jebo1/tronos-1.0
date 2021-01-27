package com.tronos.co.tronos10.service.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ActivityCalendardetailDTO implements Serializable {
    
    private Long id;

    @NotNull
    @Size(min = 4, max = 100)
    private String code;

    @NotNull
    @Size(min = 4, max = 100)
    private String description;


    private Long activityId;

    private Long calendarId;
    
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

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityCalendarId) {
        this.activityId = activityCalendarId;
    }

    public Long getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(Long academicCalendarId) {
        this.calendarId = academicCalendarId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ActivityCalendardetailDTO)) {
            return false;
        }

        return id != null && id.equals(((ActivityCalendardetailDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ActivityCalendardetailDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", activityId=" + getActivityId() +
            ", calendarId=" + getCalendarId() +
            "}";
    }
}
