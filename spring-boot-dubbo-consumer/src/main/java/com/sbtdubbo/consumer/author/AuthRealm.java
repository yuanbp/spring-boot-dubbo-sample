package com.sbtdubbo.consumer.author;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sbtdubbo.api.interfaces.system.SecPermissionService;
import com.sbtdubbo.api.interfaces.system.SecUserService;
import com.sbtdubbo.api.model.SecUser;
import com.sbtdubbo.api.utils.SpringContextHolder;

/**
 * Created by Richard on 2017/11/24 0024.
 */
@Component
public class AuthRealm extends AuthorizingRealm {

    public AuthRealm(){
        System.err.println("----------AuthRealm已实例化----------");
    }

    @Reference(interfaceName = "com.sbtdubbo.api.interfaces.system.SecUserService",interfaceClass = SecUserService.class)
    private SecUserService secUserService;

    @Reference
    private SecPermissionService secPermissionService;

    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        if(null == secUserService){
            secUserService = SpringContextHolder.getBean("secUserService");
        }
        SecUser user = secUserService.findByUserName(username);
        return new SimpleAuthenticationInfo(user, user.getPassword(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SecUser user=(SecUser) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        List<String> permissions=new ArrayList<>();
        permissions = secPermissionService.findByUserId(user.getUserId());
//        List<SecRole> roles = user.getRoles();
//        if(roles.size()>0) {
//            for(SecRole role : roles) {
//                List<SecPermission> modules = role.getPermissions();
//                if(modules.size()>0) {
//                    for(SecPermission module : modules) {
//                        permissions.add(module.getPermissionName());
//                    }
//                }
//            }
//        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);//将权限放入shiro中.
        return info;
    }

}
