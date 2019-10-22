package com.tReAsures.demo.controller;

import com.tReAsures.demo.entity.OperationUserId;
import com.tReAsures.demo.entity.User;
import com.tReAsures.demo.framework.ResponseModel;
import com.tReAsures.demo.framework.enums.ResultEnum;
import com.tReAsures.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Shuo LIANG
 * @desc login
 * 
 */

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="后台管理tReAsures的用户登录", notes="")
    @PostMapping("/login")
    public ResponseModel userLogin(@RequestBody String obj
            , HttpServletRequest req, HttpServletResponse rep){
        ResponseModel responseResult=null;
        String loginName=null;
        String password=null;
        if(obj!=null){
            JSONObject json = JSONObject.fromObject(obj);
            loginName = json.getString("loginName");
            password = json.getString("password");
        }
        try {
            responseResult=userService.userLogin(req,rep,loginName,password);
        } catch (Exception e) {
            throw new RuntimeException("Background management login exception");
        }
        return responseResult;
    }

    @GetMapping("/logout")
    @ApiOperation(value="后台管理tReAsures的用户登出", notes="")
    public ResponseModel userLogout(HttpServletRequest req, HttpServletResponse rep){
        ResponseModel responseResult=null;
        try {
            responseResult = userService.userLogout(req,rep);
        } catch (Exception e) {
            throw new RuntimeException("Backstage management exit abnormity:"+e);
        }

        return responseResult;
    }


    /**
     * 后台登录验证
     */
    @GetMapping("/verification")
    @ApiOperation(value="后台管理的登录验证",notes="")
    public ResponseModel userVerification(HttpServletRequest request){
        try {
            boolean login = OperationUserId.isLogin(request);
            if(login){
                OperationUserId.setMaxAge(request);//重新设置cookie的有效期
                User user=new User();
                user.setId(OperationUserId.getUserId(request));
                user.setUsername(OperationUserId.getUserName(request));
                return ResponseModel.ok(OperationUserId.getUser(user));
            }
            return ResponseModel.error(ResultEnum.LOGIN_NO);
        } catch (Exception e) {
            throw new RuntimeException("Verification Fail:"+e);
        }

    }
}
