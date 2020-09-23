package com.job36.service.business.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * StatViewServlet用于展示Druid的统计信息。
 * 提供监控信息展示的html页面
 * 提供监控信息的JSON API
 *
 * 内置监控页面的首页是/druid/index.html
 *
 */

/**
 * @Webservlet
 * 有两个属性可以用来表示Servlet的访问路径，分别是value和urlPatterns。value和urlPatterns都是数组形式，
 * 表示我们可以把一个Servlet映射到多个访问路径，但是value和urlPatterns不能同时使用。
 *
 */
@WebServlet(
        urlPatterns = {"/druid/*"},//#监控地址,默认 /druid/*
        initParams = {
                @WebInitParam(name = "loginUsername", value = "admin"),//#登录用户名
                @WebInitParam(name = "loginPassword", value = "123456"),//#登录密码
                @WebInitParam(name = "resetEnable", value = "false"),
//      @WebInitParam(name = "allow", value = "127.0.0.1") #IP 白名单
    }
)
public class DruidStatViewServlet extends StatViewServlet {
}