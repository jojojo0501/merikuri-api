package com.example.merikuri.mapper;

import com.example.merikuri.mapper.domain.Users;
import com.example.merikuri.mapper.domain.UsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface UsersMapper {
    long countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    @Delete({
        "delete from users",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into users (id, first_name, ",
        "last_name, age, tel, ",
        "address, email, ",
        "password, created_at, ",
        "updated_at, delete_flg)",
        "values (#{id,jdbcType=BIGINT}, #{firstName,jdbcType=VARCHAR}, ",
        "#{lastName,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER}, #{tel,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{updatedAt,jdbcType=TIMESTAMP}, #{deleteFlg,jdbcType=BIT})"
    })
    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExampleWithRowbounds(UsersExample example, RowBounds rowBounds);

    List<Users> selectByExample(UsersExample example);

    @Select({
        "select",
        "id, first_name, last_name, age, tel, address, email, password, created_at, updated_at, ",
        "delete_flg",
        "from users",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.example.merikuri.mapper.UsersMapper.BaseResultMap")
    Users selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    @Update({
        "update users",
        "set first_name = #{firstName,jdbcType=VARCHAR},",
          "last_name = #{lastName,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
          "delete_flg = #{deleteFlg,jdbcType=BIT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Users record);
}