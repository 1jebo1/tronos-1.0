package com.tronos.co.tronos10.service.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ActivityCalendarDTO implements Serializable {
    
    private Long id;

    @NotNull
    @Size(min = 4, max = 100)
    private String code;

    @NotNull
    @Size(min = 4, max = 100)
    private String description;


    private Long categoryId;
    
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long activityCalendarCategoryId) {
        this.categoryId = activityCalendarCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ActivityCalendarDTO)) {
            return false;
        }

        return id != null && id.equals(((ActivityCalendarDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ActivityCalendarDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", categoryId=" + getCategoryId() +
            "}";
    }
}
