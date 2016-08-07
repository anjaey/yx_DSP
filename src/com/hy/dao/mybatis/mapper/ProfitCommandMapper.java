package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.ProfitCommand;
import com.hy.dao.mybatis.model.ProfitCommandCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProfitCommandMapper {
    int countByExample(ProfitCommandCriteria example);

    int deleteByExample(ProfitCommandCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProfitCommand record);

    int insertSelective(ProfitCommand record);

    List<ProfitCommand> selectByExample(ProfitCommandCriteria example);

    ProfitCommand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProfitCommand record, @Param("example") ProfitCommandCriteria example);

    int updateByExample(@Param("record") ProfitCommand record, @Param("example") ProfitCommandCriteria example);

    int updateByPrimaryKeySelective(ProfitCommand record);

    int updateByPrimaryKey(ProfitCommand record);

    ProfitCommand selectByExampleForOne(ProfitCommandCriteria example);
}