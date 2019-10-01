package com.springboot.Server;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("该Filter执行了！");
        filterChain.doFilter(servletRequest,servletResponse);//直接放行请求
    }

    @Override
    public void destroy() {

    }
}
