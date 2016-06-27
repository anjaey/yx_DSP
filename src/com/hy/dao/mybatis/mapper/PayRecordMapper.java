package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.PayRecord;
import com.hy.dao.mybatis.model.PayRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayRecordMapper {
    int countByExample(PayRecordCriteria example);

    int deleteByExample(PayRecordCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayRecord record);

    int insertSelective(PayRecord record);

    List<PayRecord> selectByExample(PayRecordCriteria example);

    PayRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayRecord record, @Param("example") PayRecordCriteria example);

    int updateByExample(@Param("record") PayRecord record, @Param("example") PayRecordCriteria example);

    int updateByPrimaryKeySelective(PayRecord record);

    int updateByPrimaryKey(PayRecord record);

    PayRecord selectByExampleForOne(PayRecordCriteria example);
}