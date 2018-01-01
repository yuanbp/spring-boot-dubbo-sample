package com.sbtdubbo.api.mapper;

import com.sbtdubbo.api.model.SecUser;

public interface SecUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(SecUser record);

    int insertSelective(SecUser record);

    SecUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SecUser record);

    int updateByPrimaryKey(SecUser record);

    SecUser findByUserName(String username);
}