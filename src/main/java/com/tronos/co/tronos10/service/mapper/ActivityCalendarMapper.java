package com.tronos.co.tronos10.service.mapper;


import com.tronos.co.tronos10.domain.*;
import com.tronos.co.tronos10.service.dto.ActivityCalendarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link ActivityCalendar} and its DTO {@link ActivityCalendarDTO}.
 */
@Mapper(componentModel = "spring", uses = {com.tronos.co.tronos10.service.mapper.ActivityCalendarCategoryMapper.class})
public interface ActivityCalendarMapper extends EntityMapper<ActivityCalendarDTO, ActivityCalendar> {

    @Mapping(source = "category.id", target = "categoryId")
    ActivityCalendarDTO toDto(ActivityCalendar activityCalendar);

    @Mapping(source = "categoryId", target = "category")
    ActivityCalendar toEntity(ActivityCalendarDTO activityCalendarDTO);

    default ActivityCalendar fromId(Long id) {
        if (id == null) {
            return null;
        }
        ActivityCalendar activityCalendar = new ActivityCalendar();
        activityCalendar.setId(id);
        return activityCalendar;
    }
}
