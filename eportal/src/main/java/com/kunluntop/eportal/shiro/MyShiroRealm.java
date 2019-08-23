package com.kunluntop.eportal.shiro;

import com.kunluntop.eportal.base.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.*;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class MyShiroRealm extends AuthorizingRealm {


    final String username = "admin";//用户名
    final String password = "6a8afe58b7644ad5fc2eadd5aa236ae8";//用户密码，使用123456与fkk加密得到


    //权限信息，包括角色以及权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<>();//角色集合
        Set<String> set = new HashSet<String>();//权限集合
        set.add("test");//添加权限
        set.add("create");//添加权限
        info.setStringPermissions(set);
        System.out.print("权限添加成功");
        return info;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {

        //获取身份
        String username = (String) token.getPrincipal();
        //模拟数据库查询
        User user = queryUserByName(username);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo( user.getName(),
                user.getPassword(), // 密码
                ByteSource.Util.bytes(user.getSalt()),
                getName());
        return authenticationInfo;
    }
    @Override
    public boolean isPermitted(Permission permission,AuthorizationInfo info){
        Collection<Permission> perms= this.getPermissions(info);
        if (perms!=null&&!perms.isEmpty()){
            Iterator<Permission> iterator=perms.iterator();
            while (iterator.hasNext()){
                Permission perm=iterator.next();
                if (perm.implies(permission)){
                    return  true;
                }
            }
        }
        return  false;
    }


    User queryUserByName(String username){
        User user=new User();
        user.setName(username);
        user.setPassword("12313");
        user.setPassword(password);
        user.setSalt("fkk");
        user.setId("1");
        return user;
    }




}
