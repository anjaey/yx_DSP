package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.Navigation;
import com.hy.dao.mybatis.model.NavigationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NavigationMapper {
    int countByExample(NavigationCriteria example);

    int deleteByExample(NavigationCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Navigation record);

    int insertSelective(Navigation record);

    List<Navigation> selectByExample(NavigationCriteria example);

    Navigation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Navigation record, @Param("example") NavigationCriteria example);

    int updateByExample(@Param("record") Navigation record, @Param("example") NavigationCriteria example);

    int updateByPrimaryKeySelective(Navigation record);

    int updateByPrimaryKey(Navigation record);

    Navigation selectByExampleForOne(NavigationCriteria example);
}