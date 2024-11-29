package org.tsubakice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.tsubakice.data.table.City;

import java.util.List;

@Mapper
public interface CityMapper {
    @Select("select  * from cities")
    List<City> getAll();
}
