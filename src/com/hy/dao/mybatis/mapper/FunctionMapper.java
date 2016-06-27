package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.Function;
import com.hy.dao.mybatis.model.FunctionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunctionMapper {
    int countByExample(FunctionCriteria example);

    int deleteByExample(FunctionCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Function record);

    int insertSelective(Function record);

    List<Function> selectByExample(FunctionCriteria example);

    Function selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Function record, @Param("example") FunctionCriteria example);

    int updateByExample(@Param("record") Function record, @Param("example") FunctionCriteria example);

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);

    Function selectByExampleForOne(FunctionCriteria example);
}