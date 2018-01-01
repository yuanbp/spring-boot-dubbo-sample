package com.sbtdubbo.provider.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.sbtdubbo.api.interfaces.system.SecPermissionService;
import com.sbtdubbo.api.mapper.SecPermissionMapper;

/**
 * Created by Richard on 2017/11/29 0029.
 */
@Service(interfaceName = "com.sbtdubbo.api.interfaces.system.SecPermissionService",interfaceClass = SecPermissionService.class)
public class SecPermissionServiceImpl implements SecPermissionService {

    @Autowired
    private SecPermissionMapper secPermissionMapper;

    @Override
    public List<String> findByUserId(String userid) {
        return secPermissionMapper.findByUserId(userid);
    }
}
