package com.hy.dao.mybatis.mapper;

import com.hy.dao.mybatis.model.NavPrivilege;
import com.hy.dao.mybatis.model.NavPrivilegeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NavPrivilegeMapper {
    int countByExample(NavPrivilegeCriteria example);

    int deleteByExample(NavPrivilegeCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(NavPrivilege record);

    int insertSelective(NavPrivilege record);

    List<NavPrivilege> selectByExample(NavPrivilegeCriteria example);

    NavPrivilege selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NavPrivilege record, @Param("example") NavPrivilegeCriteria example);

    int updateByExample(@Param("record") NavPrivilege record, @Param("example") NavPrivilegeCriteria example);

    int updateByPrimaryKeySelective(NavPrivilege record);

    int updateByPrimaryKey(NavPrivilege record);

    NavPrivilege selectByExampleForOne(NavPrivilegeCriteria example);
}