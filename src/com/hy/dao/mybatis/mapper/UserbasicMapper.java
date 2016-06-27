package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.Userbasic;
import com.hy.dao.mybatis.model.UserbasicCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserbasicMapper {
    int countByExample(UserbasicCriteria example);

    int deleteByExample(UserbasicCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Userbasic record);

    int insertSelective(Userbasic record);

    List<Userbasic> selectByExample(UserbasicCriteria example);

    Userbasic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Userbasic record, @Param("example") UserbasicCriteria example);

    int updateByExample(@Param("record") Userbasic record, @Param("example") UserbasicCriteria example);

    int updateByPrimaryKeySelective(Userbasic record);

    int updateByPrimaryKey(Userbasic record);

    Userbasic selectByExampleForOne(UserbasicCriteria example);
}