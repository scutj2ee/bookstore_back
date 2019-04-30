package com.scutj2ee.bookstore.config;

import com.scutj2ee.bookstore.entity.Permission;
import com.scutj2ee.bookstore.entity.Role;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.service.PermissionService;
import com.scutj2ee.bookstore.service.RoleService;
import com.scutj2ee.bookstore.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/27 22:49
 * @ Description：${description}
 * @ Modified By：
 */
public class ShiroRealm extends AuthorizingRealm {
    private final static Logger logger=LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("权限配置-->ShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user  = (User)principals.getPrimaryPrincipal();
        for(Role role:roleService.findbyUserId(user.getId())){
            authorizationInfo.addRole(role.getRolename());
            for(Permission p:permissionService.findByRoleId(role.getRoleId())){
                authorizationInfo.addStringPermission((p.getName()));
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("ShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        logger.info((String) token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user = userService.findByUsername(username);
        logger.info("----->>userInfo="+user);
        if(user == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getUsername()),
                getName()  //realm name
        );
        return authenticationInfo;
    }
}

