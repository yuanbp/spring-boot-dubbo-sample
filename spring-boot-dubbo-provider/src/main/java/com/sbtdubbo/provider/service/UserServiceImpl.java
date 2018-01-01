package com.sbtdubbo.provider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.sbtdubbo.api.interfaces.UserService;
import com.sbtdubbo.api.mapper.UserMapper;
import com.sbtdubbo.api.model.User;

/**
 * Created by Richard on 2017/11/23 0023.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(Integer id) throws Exception {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public List<User> selectBySelective(User record) throws Exception {
        return userMapper.selectBySelective(record);
    }
}
