package com.tronos.co.tronos10.service.mapper;


import com.tronos.co.tronos10.domain.*;
import com.tronos.co.tronos10.service.dto.ActivityCalendarCategoryDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface ActivityCalendarCategoryMapper extends EntityMapper<ActivityCalendarCategoryDTO, ActivityCalendarCategory> {



    default ActivityCalendarCategory fromId(Long id) {
        if (id == null) {
            return null;
        }
        ActivityCalendarCategory activityCalendarCategory = new ActivityCalendarCategory();
        activityCalendarCategory.setId(id);
        return activityCalendarCategory;
    }
}
