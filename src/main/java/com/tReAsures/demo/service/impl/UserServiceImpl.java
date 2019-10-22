package com.tReAsures.demo.service.impl;

import com.tReAsures.demo.dao.UserDao;
import com.tReAsures.demo.entity.User;
import com.tReAsures.demo.framework.ResponseModel;
import com.tReAsures.demo.framework.enums.ResultEnum;
import com.tReAsures.demo.entity.OperationUserId;
import com.tReAsures.demo.service.UserService;
import com.tReAsures.demo.utils.Cache;
import com.tReAsures.demo.utils.CacheManager;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Value("${cookie.key}")
	private String CAP_MANAGER_LOGIN;

	@Override
	public ResponseModel userLogin(HttpServletRequest req, HttpServletResponse rep,
			String userName, String password)throws Exception {

		if(!StringUtils.isBlank(userName)){
			User user = userDao.getUserName(userName);
			if(user!=null && user.getUsername()!=null){
				if(!StringUtils.isBlank(password) && password.equals(user.getPassword())){
					String uuid = UUID.randomUUID().toString();
					Cookie cookie = new Cookie(CAP_MANAGER_LOGIN, uuid);
					cookie.setMaxAge(60 * 60 * 24);
					cookie.setPath("/");
					rep.addCookie(cookie);
					JSONObject json= OperationUserId.getUser(user);
					//将用户信息放到自定义的map返回
					Cache cache=new Cache(user.getId()+"",user.getUsername());
					CacheManager.putCache(uuid,cache);
					return ResponseModel.ok(json);
				}
				return ResponseModel.error(ResultEnum.LOGIN_PASSWORD);
			}
			return ResponseModel.error(ResultEnum.LOGIN_NAME);
		}
		return ResponseModel.error(ResultEnum.LOGIN_NAME);
	}

	@Override
	public ResponseModel userLogout(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		String token = OperationUserId.getToken(req);
		Cookie cookie = new Cookie(CAP_MANAGER_LOGIN,"");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		rep.addCookie(cookie);
		if(CacheManager.hasCache(token))CacheManager.clearOnly(token);
		return ResponseModel.ok("Withdraw from success");
	}

}
