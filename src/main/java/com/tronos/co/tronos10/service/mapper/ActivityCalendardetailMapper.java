package com.tronos.co.tronos10.service.mapper;


import com.tronos.co.tronos10.domain.*;
import com.tronos.co.tronos10.service.dto.ActivityCalendardetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link ActivityCalendardetail} and its DTO {@link ActivityCalendardetailDTO}.
 */
@Mapper(componentModel = "spring", uses = {ActivityCalendarMapper.class, com.tronos.co.tronos10.service.mapper.AcademicCalendarMapper.class})
public interface ActivityCalendardetailMapper extends EntityMapper<ActivityCalendardetailDTO, ActivityCalendardetail> {

    @Mapping(source = "activity.id", target = "activityId")
    @Mapping(source = "calendar.id", target = "calendarId")
    ActivityCalendardetailDTO toDto(ActivityCalendardetail activityCalendardetail);

    @Mapping(source = "activityId", target = "activity")
    @Mapping(source = "calendarId", target = "calendar")
    ActivityCalendardetail toEntity(ActivityCalendardetailDTO activityCalendardetailDTO);

    default ActivityCalendardetail fromId(Long id) {
        if (id == null) {
            return null;
        }
        ActivityCalendardetail activityCalendardetail = new ActivityCalendardetail();
        activityCalendardetail.setId(id);
        return activityCalendardetail;
    }
}
