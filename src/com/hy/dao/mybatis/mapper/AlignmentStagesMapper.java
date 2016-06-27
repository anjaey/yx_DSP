package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.AlignmentStages;
import com.hy.dao.mybatis.model.AlignmentStagesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlignmentStagesMapper {
    int countByExample(AlignmentStagesCriteria example);

    int deleteByExample(AlignmentStagesCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AlignmentStages record);

    int insertSelective(AlignmentStages record);

    List<AlignmentStages> selectByExample(AlignmentStagesCriteria example);

    AlignmentStages selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AlignmentStages record, @Param("example") AlignmentStagesCriteria example);

    int updateByExample(@Param("record") AlignmentStages record, @Param("example") AlignmentStagesCriteria example);

    int updateByPrimaryKeySelective(AlignmentStages record);

    int updateByPrimaryKey(AlignmentStages record);

    AlignmentStages selectByExampleForOne(AlignmentStagesCriteria example);
}