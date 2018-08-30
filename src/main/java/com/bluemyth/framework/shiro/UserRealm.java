package com.bluemyth.framework.shiro;

import com.bluemyth.sys.utils.BaseConstant;
import com.bluemyth.sys.entity.Menu;
import com.bluemyth.sys.entity.Roleuser;
import com.bluemyth.sys.entity.User;
import com.bluemyth.sys.mapper.MenuMapper;
import com.bluemyth.sys.mapper.RoleuserMapper;
import com.bluemyth.sys.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 认证
 * 
 * Create by xiaot on 2018/6/14
 */
@Component
public class UserRealm extends AuthorizingRealm {

	@Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;
	@Autowired
	private RoleuserMapper roleuserMapper;
    
    /**
     * 授权(验证权限时调用)
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user = (User)principals.getPrimaryPrincipal();
		String userid = user.getUserid();

		List<String> permsList;

		//查询角色
		Roleuser roleuser = new Roleuser();
		roleuser.setUserid(userid);
		roleuser = roleuserMapper.selectOne(roleuser);

		if(roleuser !=null) {
			//系统管理员，拥有最高权限
			if (BaseConstant.SUPER_ADMIN_KEY.equals(roleuser.getUserid())) {
				List<Menu> menuList = menuMapper.selectList(null);
				permsList = new ArrayList<>(menuList.size());
				for (Menu menu : menuList) {
					permsList.add(menu.getPerms());
				}
			} else {
				permsList = userMapper.queryAllPerms(userid);
			}
		}else {
			permsList = new ArrayList<>();
		}

		//用户权限列表
		Set<String> permsSet = new HashSet<>();
		for(String perms : permsList){
			if(StringUtils.isBlank(perms)){
				continue;
			}
			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permsSet);
		return info;
	}

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;

		//查询用户信息
		User user = new User();
		user.setAccount(token.getUsername());
		user = userMapper.selectOne(user);

		//账号不存在
		if(user == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}

		//账号锁定
		if(user.getStatus() == 0){
			throw new LockedAccountException("账号已被锁定,请联系管理员");
		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(ShiroUtils.default_salt), getName());
		return info;
	}

	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
		shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
		shaCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
		super.setCredentialsMatcher(shaCredentialsMatcher);
	}
}
