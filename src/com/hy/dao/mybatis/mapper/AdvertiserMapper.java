package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.Advertiser;
import com.hy.dao.mybatis.model.AdvertiserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvertiserMapper {
    int countByExample(AdvertiserCriteria example);

    int deleteByExample(AdvertiserCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Advertiser record);

    int insertSelective(Advertiser record);

    List<Advertiser> selectByExample(AdvertiserCriteria example);

    Advertiser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Advertiser record, @Param("example") AdvertiserCriteria example);

    int updateByExample(@Param("record") Advertiser record, @Param("example") AdvertiserCriteria example);

    int updateByPrimaryKeySelective(Advertiser record);

    int updateByPrimaryKey(Advertiser record);

    Advertiser selectByExampleForOne(AdvertiserCriteria example);
}