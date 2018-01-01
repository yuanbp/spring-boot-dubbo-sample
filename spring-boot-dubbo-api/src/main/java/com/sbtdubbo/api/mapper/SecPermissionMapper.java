package com.sbtdubbo.api.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbtdubbo.api.model.SecPermission;

@Repository
public interface SecPermissionMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(SecPermission record);

    int insertSelective(SecPermission record);

    SecPermission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(SecPermission record);

    int updateByPrimaryKey(SecPermission record);

    List<String> findByUserId(String userid);
}