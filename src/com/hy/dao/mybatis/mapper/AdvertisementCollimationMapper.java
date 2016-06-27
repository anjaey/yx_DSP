package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.AdvertisementCollimation;
import com.hy.dao.mybatis.model.AdvertisementCollimationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvertisementCollimationMapper {
    int countByExample(AdvertisementCollimationCriteria example);

    int deleteByExample(AdvertisementCollimationCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdvertisementCollimation record);

    int insertSelective(AdvertisementCollimation record);

    List<AdvertisementCollimation> selectByExample(AdvertisementCollimationCriteria example);

    AdvertisementCollimation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdvertisementCollimation record, @Param("example") AdvertisementCollimationCriteria example);

    int updateByExample(@Param("record") AdvertisementCollimation record, @Param("example") AdvertisementCollimationCriteria example);

    int updateByPrimaryKeySelective(AdvertisementCollimation record);

    int updateByPrimaryKey(AdvertisementCollimation record);

    AdvertisementCollimation selectByExampleForOne(AdvertisementCollimationCriteria example);
}