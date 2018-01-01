package com.sbtdubbo.api.mapper;

import com.sbtdubbo.api.model.SecUserRole;

public interface SecUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SecUserRole record);

    int insertSelective(SecUserRole record);

    SecUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SecUserRole record);

    int updateByPrimaryKey(SecUserRole record);
}