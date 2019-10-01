package com.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    //在目标方法执行之前执行preHandle方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object person= request.getSession().getAttribute("name");
        if (person==null){
            request.setAttribute("msg","没有权限，请先登录！");
            //转发到登陆界面（在Controller中配置了视图映射）
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            return true;//已登录，放行
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
