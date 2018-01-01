package com.sbtdubbo.api.interfaces.system;

import com.sbtdubbo.api.model.SecUser;

/**
 * Created by Richard on 2017/11/24 0024.
 */
public interface SecUserService {
    SecUser findByUserName(String username);
}
