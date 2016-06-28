package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.Invoice;
import com.hy.dao.mybatis.model.InvoiceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InvoiceMapper {
    int countByExample(InvoiceCriteria example);

    int deleteByExample(InvoiceCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Invoice record);

    int insertSelective(Invoice record);

    List<Invoice> selectByExample(InvoiceCriteria example);

    Invoice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Invoice record, @Param("example") InvoiceCriteria example);

    int updateByExample(@Param("record") Invoice record, @Param("example") InvoiceCriteria example);

    int updateByPrimaryKeySelective(Invoice record);

    int updateByPrimaryKey(Invoice record);

    Invoice selectByExampleForOne(InvoiceCriteria example);
}