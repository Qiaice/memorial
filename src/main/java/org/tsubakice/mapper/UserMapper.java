package org.tsubakice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.tsubakice.data.table.User;

@Mapper
public interface UserMapper {

    /**
     * 根据用户名查找用户
     * @param uname 用户名
     * @return 封装好的用户信息对象
     */
    @Select(value = { "select * from users where uname = #{uname}" })
    public abstract User selectUserByUname(String uname);

    /**
     * 将用户信息添加进数据库
     * @param user 存储了用户信息的对象
     * @return 数据表被影响的行数
     */
//    @AutoFill(value= OperationType.INSERT)
//    @Insert(value = { "insert into users (uname, passwd) values (#{uname}, #{passwd})" })
    public abstract int insertUser(User user);

    @Update(value = "update users set passwd = #{passwd} where uname = #{uname}")
    int updatePasswdByUname(String uname, String passwd);
}
