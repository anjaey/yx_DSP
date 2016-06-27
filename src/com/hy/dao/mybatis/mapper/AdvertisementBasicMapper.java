package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.AdvertisementBasic;
import com.hy.dao.mybatis.model.AdvertisementBasicCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvertisementBasicMapper {
    int countByExample(AdvertisementBasicCriteria example);

    int deleteByExample(AdvertisementBasicCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdvertisementBasic record);

    int insertSelective(AdvertisementBasic record);

    List<AdvertisementBasic> selectByExample(AdvertisementBasicCriteria example);

    AdvertisementBasic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdvertisementBasic record, @Param("example") AdvertisementBasicCriteria example);

    int updateByExample(@Param("record") AdvertisementBasic record, @Param("example") AdvertisementBasicCriteria example);

    int updateByPrimaryKeySelective(AdvertisementBasic record);

    int updateByPrimaryKey(AdvertisementBasic record);

    AdvertisementBasic selectByExampleForOne(AdvertisementBasicCriteria example);
}