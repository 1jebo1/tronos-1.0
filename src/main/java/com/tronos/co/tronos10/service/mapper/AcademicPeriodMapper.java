package com.tronos.co.tronos10.service.mapper;


import com.tronos.co.tronos10.domain.*;
import com.tronos.co.tronos10.service.dto.AcademicPeriodDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface AcademicPeriodMapper extends EntityMapper<AcademicPeriodDTO, AcademicPeriod> {



    default AcademicPeriod fromId(Long id) {
        if (id == null) {
            return null;
        }
        AcademicPeriod academicPeriods = new AcademicPeriod();
        academicPeriods.setId(id);
        return academicPeriods;
    }
}
