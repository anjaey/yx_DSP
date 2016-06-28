package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.AlignmentPlatform;
import com.hy.dao.mybatis.model.AlignmentPlatformCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlignmentPlatformMapper {
    int countByExample(AlignmentPlatformCriteria example);

    int deleteByExample(AlignmentPlatformCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AlignmentPlatform record);

    int insertSelective(AlignmentPlatform record);

    List<AlignmentPlatform> selectByExample(AlignmentPlatformCriteria example);

    AlignmentPlatform selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AlignmentPlatform record, @Param("example") AlignmentPlatformCriteria example);

    int updateByExample(@Param("record") AlignmentPlatform record, @Param("example") AlignmentPlatformCriteria example);

    int updateByPrimaryKeySelective(AlignmentPlatform record);

    int updateByPrimaryKey(AlignmentPlatform record);

    AlignmentPlatform selectByExampleForOne(AlignmentPlatformCriteria example);
}