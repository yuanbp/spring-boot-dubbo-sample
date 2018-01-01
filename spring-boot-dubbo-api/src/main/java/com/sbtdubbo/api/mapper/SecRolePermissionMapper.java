package com.sbtdubbo.api.mapper;

import com.sbtdubbo.api.model.SecRolePermission;

public interface SecRolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SecRolePermission record);

    int insertSelective(SecRolePermission record);

    SecRolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SecRolePermission record);

    int updateByPrimaryKey(SecRolePermission record);
}