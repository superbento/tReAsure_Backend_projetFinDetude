package com.tReAsures.demo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tReAsures.demo.framework.ResponseModel;

public interface UserService {
	ResponseModel userLogout(HttpServletRequest req, HttpServletResponse rep)throws Exception;
	ResponseModel userLogin(HttpServletRequest req, HttpServletResponse rep, String loginName, String password)throws Exception;
}
