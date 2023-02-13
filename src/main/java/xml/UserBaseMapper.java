package xml;

import com.example.merikuri.mapper.domain.UserBase;
import com.example.merikuri.mapper.domain.UserBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface UserBaseMapper {
    long countByExample(UserBaseExample example);

    int deleteByExample(UserBaseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserBase record);

    int insertSelective(UserBase record);

    List<UserBase> selectByExampleWithRowbounds(UserBaseExample example, RowBounds rowBounds);

    List<UserBase> selectByExample(UserBaseExample example);

    UserBase selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserBase record, @Param("example") UserBaseExample example);

    int updateByExample(@Param("record") UserBase record, @Param("example") UserBaseExample example);

    int updateByPrimaryKeySelective(UserBase record);

    int updateByPrimaryKey(UserBase record);
}