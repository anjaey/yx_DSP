package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.AddressProvinces;
import com.hy.dao.mybatis.model.AddressProvincesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressProvincesMapper {
    int countByExample(AddressProvincesCriteria example);

    int deleteByExample(AddressProvincesCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AddressProvinces record);

    int insertSelective(AddressProvinces record);

    List<AddressProvinces> selectByExample(AddressProvincesCriteria example);

    AddressProvinces selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AddressProvinces record, @Param("example") AddressProvincesCriteria example);

    int updateByExample(@Param("record") AddressProvinces record, @Param("example") AddressProvincesCriteria example);

    int updateByPrimaryKeySelective(AddressProvinces record);

    int updateByPrimaryKey(AddressProvinces record);

    AddressProvinces selectByExampleForOne(AddressProvincesCriteria example);
}