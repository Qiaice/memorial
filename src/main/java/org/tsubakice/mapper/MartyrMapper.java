package org.tsubakice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.tsubakice.data.table.Martyr;

import java.util.List;

@Mapper
public interface MartyrMapper {

    @Select(value = { "select * from martyrs where mid = #{mid}" })
    Martyr selectMartyrById(Integer mid);

    @Select(value = { "select * from martyrs" })
    List<Martyr> selectAllMartyrs();

    @Select(value = { "select m.* from facilities as f inner join martyrs as m on f.fid = m.fid where cid = #{cid}" })
    List<Martyr> selectAllMartyrsByCid(Integer cid);
}
