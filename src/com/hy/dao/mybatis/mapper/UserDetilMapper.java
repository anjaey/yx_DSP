package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.UserDetil;
import com.hy.dao.mybatis.model.UserDetilCriteria;
import com.hy.dao.mybatis.model.UserDetilKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDetilMapper {
    int countByExample(UserDetilCriteria example);

    int deleteByExample(UserDetilCriteria example);

    int deleteByPrimaryKey(UserDetilKey key);

    int insert(UserDetil record);

    int insertSelective(UserDetil record);

    List<UserDetil> selectByExample(UserDetilCriteria example);

    UserDetil selectByPrimaryKey(UserDetilKey key);

    int updateByExampleSelective(@Param("record") UserDetil record, @Param("example") UserDetilCriteria example);

    int updateByExample(@Param("record") UserDetil record, @Param("example") UserDetilCriteria example);

    int updateByPrimaryKeySelective(UserDetil record);

    int updateByPrimaryKey(UserDetil record);

    UserDetil selectByExampleForOne(UserDetilCriteria example);
}