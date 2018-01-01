package com.sbtdubbo.api.interfaces;


import java.util.List;

import com.sbtdubbo.api.model.User;

/**
 * Created by Richard on 2017/11/23 0023.
 */
public interface UserService {

    User selectByPrimaryKey(Integer id) throws Exception;

    List<User> selectBySelective(User record) throws Exception;
}
