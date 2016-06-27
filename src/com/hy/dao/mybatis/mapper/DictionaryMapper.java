package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.Dictionary;
import com.hy.dao.mybatis.model.DictionaryCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictionaryMapper {
    int countByExample(DictionaryCriteria example);

    int deleteByExample(DictionaryCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    List<Dictionary> selectByExample(DictionaryCriteria example);

    Dictionary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dictionary record, @Param("example") DictionaryCriteria example);

    int updateByExample(@Param("record") Dictionary record, @Param("example") DictionaryCriteria example);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);

    Dictionary selectByExampleForOne(DictionaryCriteria example);
}