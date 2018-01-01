package com.sbtdubbo.provider.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.sbtdubbo.api.interfaces.system.SecUserService;
import com.sbtdubbo.api.mapper.SecUserMapper;
import com.sbtdubbo.api.model.SecUser;

/**
 * Created by Richard on 2017/11/24 0024.
 */
@Service(interfaceName = "com.sbtdubbo.api.interfaces.system.SecUserService",interfaceClass = SecUserService.class)
public class SecUserServiceImpl implements SecUserService {

    @Autowired
    private SecUserMapper secUserMapper;

    @Override
    @Transactional(readOnly = true)
    public SecUser findByUserName(String username) {
        return secUserMapper.findByUserName(username);
    }
}
