package org.tsubakice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.tsubakice.data.table.Facility;

import java.util.List;

@Mapper
public interface FacilityMapper {

    @Select(value = "select * from facilities")
    List<Facility> list();

    @Select(value = "select * from facilities where fid = #{fid}")
    Facility selectByFid(Integer fid);
}
