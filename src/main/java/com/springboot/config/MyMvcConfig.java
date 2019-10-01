package com.springboot.config;

import com.springboot.component.LoginHandlerInterceptor;
import com.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
@Configuration//声明为配置类，相当于配置文件
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Bean//将组件注册到容器中,使用自己定义的LocaleResolver
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    @Bean//将组件注册到容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter=new WebMvcConfigurerAdapter(){
            @Override//添加视图映射,当发送main.html请求时，会跳转到shouye/zong.html页面
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("main.html").setViewName("shouye/zong");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
                        excludePathPatterns("/index.html","/","/person/login","/img/**");//拦截任意多层路径
               // 下的任意请求（/**），排除了"/index.html","/","/person/login"请求。
                //SpringBoot已经做好了静态资源的映射，我们不用管静态资源，浏览器就能够正常访问。
            }
        };
        return adapter;
    }
}
