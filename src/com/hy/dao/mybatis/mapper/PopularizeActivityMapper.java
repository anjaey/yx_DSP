package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.PopularizeActivity;
import com.hy.dao.mybatis.model.PopularizeActivityCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PopularizeActivityMapper {
    int countByExample(PopularizeActivityCriteria example);

    int deleteByExample(PopularizeActivityCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(PopularizeActivity record);

    int insertSelective(PopularizeActivity record);

    List<PopularizeActivity> selectByExample(PopularizeActivityCriteria example);

    PopularizeActivity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PopularizeActivity record, @Param("example") PopularizeActivityCriteria example);

    int updateByExample(@Param("record") PopularizeActivity record, @Param("example") PopularizeActivityCriteria example);

    int updateByPrimaryKeySelective(PopularizeActivity record);

    int updateByPrimaryKey(PopularizeActivity record);

    PopularizeActivity selectByExampleForOne(PopularizeActivityCriteria example);
}