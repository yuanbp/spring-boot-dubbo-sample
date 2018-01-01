package com.sbtdubbo.api.interfaces.system;

import java.util.List;

/**
 * Created by Richard on 2017/11/29 0029.
 */
public interface SecPermissionService {
    List<String> findByUserId(String userid);
}
