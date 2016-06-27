package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.FunctionRole;
import com.hy.dao.mybatis.model.FunctionRoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunctionRoleMapper {
    int countByExample(FunctionRoleCriteria example);

    int deleteByExample(FunctionRoleCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(FunctionRole record);

    int insertSelective(FunctionRole record);

    List<FunctionRole> selectByExample(FunctionRoleCriteria example);

    FunctionRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FunctionRole record, @Param("example") FunctionRoleCriteria example);

    int updateByExample(@Param("record") FunctionRole record, @Param("example") FunctionRoleCriteria example);

    int updateByPrimaryKeySelective(FunctionRole record);

    int updateByPrimaryKey(FunctionRole record);

    FunctionRole selectByExampleForOne(FunctionRoleCriteria example);
}