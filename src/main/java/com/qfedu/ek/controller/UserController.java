package com.qfedu.ek.controller;

import com.qfedu.ek.common.JsonResult;
import com.qfedu.ek.entity.User;
import com.qfedu.ek.service.UserService;
import com.qfedu.ek.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//修饰类
@Api(description = "衣库管理的api")
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录", notes = "根据账户密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "用户的账户", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "用户的密码", required = true, paramType = "query")
    })
    @RequestMapping("/login.do")
    @ResponseBody
    public JsonResult login(String account, String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = userService.login(account, password);
        if (user == null) {
            return new JsonResult(0, "未登录！！");
        }
        return new JsonResult(1, "登陆成功！");
    }


    @ApiOperation(value = "用户注册", notes = "根据注册账户，密码，再次确认密码，进行注册")
    @RequestMapping("/regist.do")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "用户的账户", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "用户的密码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "passwordagain", value = "用户再次输入的密码", required = true, paramType = "query")

    })
    public JsonResult regist(String nickname,String account, String password, String passwordagain) {

        try {

            JsonResult jsonResult = new JsonResult();
            userService.add(nickname, account, password, passwordagain);

            return JsonUtils.createJsonResult(1, "注册成功！！");

        } catch (Exception e) {
            return JsonUtils.createJsonResult(0, e.getMessage());

        }
    }

}
