package org.tsubakice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.tsubakice.data.table.Martyr;

@Mapper
public interface MartyrMapper {

    @Select(value = { "select * from martyrs where mid = #{mid}" })
    Martyr selectMartyrById(Integer mid);
}
