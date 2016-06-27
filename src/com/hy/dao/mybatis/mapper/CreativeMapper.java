package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.Creative;
import com.hy.dao.mybatis.model.CreativeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreativeMapper {
    int countByExample(CreativeCriteria example);

    int deleteByExample(CreativeCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Creative record);

    int insertSelective(Creative record);

    List<Creative> selectByExample(CreativeCriteria example);

    Creative selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Creative record, @Param("example") CreativeCriteria example);

    int updateByExample(@Param("record") Creative record, @Param("example") CreativeCriteria example);

    int updateByPrimaryKeySelective(Creative record);

    int updateByPrimaryKey(Creative record);

    Creative selectByExampleForOne(CreativeCriteria example);
}