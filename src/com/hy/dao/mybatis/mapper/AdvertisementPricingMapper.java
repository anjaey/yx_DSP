package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.AdvertisementPricing;
import com.hy.dao.mybatis.model.AdvertisementPricingCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvertisementPricingMapper {
    int countByExample(AdvertisementPricingCriteria example);

    int deleteByExample(AdvertisementPricingCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdvertisementPricing record);

    int insertSelective(AdvertisementPricing record);

    List<AdvertisementPricing> selectByExample(AdvertisementPricingCriteria example);

    AdvertisementPricing selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdvertisementPricing record, @Param("example") AdvertisementPricingCriteria example);

    int updateByExample(@Param("record") AdvertisementPricing record, @Param("example") AdvertisementPricingCriteria example);

    int updateByPrimaryKeySelective(AdvertisementPricing record);

    int updateByPrimaryKey(AdvertisementPricing record);

    AdvertisementPricing selectByExampleForOne(AdvertisementPricingCriteria example);
}