package com.lamlake.example.config;

import com.lamlake.example.entity.Resource;
import com.lamlake.example.entity.SysRole;
import com.lamlake.example.entity.UserInfo;
import com.lamlake.example.service.IResourceService;
import com.lamlake.example.service.ISysRoleService;
import com.lamlake.example.service.IUserInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private ISysRoleService sysRoleService;
    @Autowired
    private IResourceService resourceService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        try {

            String account = (String)principals.getPrimaryPrincipal();
            UserInfo userInfo = userInfoService.findByAccount(account);
            List<SysRole> roleList = sysRoleService.getRolesByUserId(userInfo.getId());
            for (SysRole role : roleList) {
                System.out.println("role name--> " + role.getRoleName());
                authorizationInfo.addRole(role.getRoleName());
                List<Resource> resourceList = resourceService.getResourcesByRoleId(role.getId());
                for (Resource resource : resourceList) {
                    System.out.println("resource name-->" + resource.getName());
                    System.out.println("resource Operations-->" + resource.getOperations());
                    authorizationInfo.addStringPermission(resource.getOperations());
                }
            }
            System.out.println("权限-->" + authorizationInfo.getStringPermissions());
        } catch (Exception e) {
            System.out.println("异常名称-->" + e.getClass().getName());
        }
        return authorizationInfo;
    }

    /* 主要用来进行身份认证 */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
        System.out.println("身份认证...");
        String account = usernamePasswordToken.getUsername();
        String password = new String(usernamePasswordToken.getPassword()).trim();
        System.out.println("account-->" + account);
        System.out.println("password-->" + password);
        System.out.println(token.getCredentials());
        UserInfo userInfo = userInfoService.findByAccount(account);
        System.out.println("userInfo-->" + userInfo);
        if (userInfo != null) {
            System.out.println("getName()-->" + getName());
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo.getAccount(), userInfo.getPassword(), getName());
            return authenticationInfo;
        }
        return null;

    }
}
