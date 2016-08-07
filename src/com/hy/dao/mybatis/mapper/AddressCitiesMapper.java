package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.AddressCities;
import com.hy.dao.mybatis.model.AddressCitiesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressCitiesMapper {
    int countByExample(AddressCitiesCriteria example);

    int deleteByExample(AddressCitiesCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AddressCities record);

    int insertSelective(AddressCities record);

    List<AddressCities> selectByExample(AddressCitiesCriteria example);

    AddressCities selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AddressCities record, @Param("example") AddressCitiesCriteria example);

    int updateByExample(@Param("record") AddressCities record, @Param("example") AddressCitiesCriteria example);

    int updateByPrimaryKeySelective(AddressCities record);

    int updateByPrimaryKey(AddressCities record);

    AddressCities selectByExampleForOne(AddressCitiesCriteria example);
}