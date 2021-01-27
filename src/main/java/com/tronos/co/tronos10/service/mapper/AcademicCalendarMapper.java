package com.tronos.co.tronos10.service.mapper;


import com.tronos.co.tronos10.domain.*;
import com.tronos.co.tronos10.service.dto.AcademicCalendarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AcademicPeriodMapper.class})
public interface AcademicCalendarMapper extends EntityMapper<AcademicCalendarDTO, AcademicCalendar> {

    @Mapping(source = "period.id", target = "periodId")
    AcademicCalendarDTO toDto(AcademicCalendar academicCalendar);

    @Mapping(source = "periodId", target = "period")
    AcademicCalendar toEntity(AcademicCalendarDTO academicCalendarDTO);

    default AcademicCalendar fromId(Long id) {
        if (id == null) {
            return null;
        }
        AcademicCalendar academicCalendar = new AcademicCalendar();
        academicCalendar.setId(id);
        return academicCalendar;
    }
}
