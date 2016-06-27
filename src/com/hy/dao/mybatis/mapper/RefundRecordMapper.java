package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.RefundRecord;
import com.hy.dao.mybatis.model.RefundRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefundRecordMapper {
    int countByExample(RefundRecordCriteria example);

    int deleteByExample(RefundRecordCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RefundRecord record);

    int insertSelective(RefundRecord record);

    List<RefundRecord> selectByExample(RefundRecordCriteria example);

    RefundRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RefundRecord record, @Param("example") RefundRecordCriteria example);

    int updateByExample(@Param("record") RefundRecord record, @Param("example") RefundRecordCriteria example);

    int updateByPrimaryKeySelective(RefundRecord record);

    int updateByPrimaryKey(RefundRecord record);

    RefundRecord selectByExampleForOne(RefundRecordCriteria example);
}