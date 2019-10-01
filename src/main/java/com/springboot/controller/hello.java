package com.springboot.controller;

import com.springboot.bean.user;
import com.springboot.dao.moniDao;
import com.springboot.mapper.catMapper;
import com.springboot.mapper.dogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class hello {

    @Autowired//注入mapper
    private dogMapper dogMapper;

    @Autowired
    private catMapper catMapper;

    @Autowired
    private moniDao moniDao;
    @ResponseBody
    @RequestMapping("/hello")
    public String hell()
    {
        return "yang!";
    }

    @RequestMapping({"/","/index.html"})
    public String index(){
        return "denglu";
    }

    @RequestMapping("/success")
    public String succ(Map<String,Object> map){
        map.put("hai",1);
        return "success";
    }

    @PostMapping("/person/login")
    public String login(@RequestParam("uname") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("name",username);
           return "redirect:/main.html";//重定向
        }else {
            map.put("msg","用户名或者密码错误！");
            return "denglu";
        }
    }

    @RequestMapping("/emps")
    public String yuangongList(Model model){
        List<user> userList=moniDao.getAllPerson();
        model.addAttribute("user",userList);
        return "yuangong";
    }

    @RequestMapping("/shouye/zong.html")
    public String l1(){
        return "shouye/zong";
    }

    @RequestMapping("/add")
    public String addYuanGong(){
        return "addYuanGong";
    }

    @PostMapping("/addYuanGong")
    public String addYuanGong1(user user){//springMVC自动将请求参数与入参对象得分属性进行
        //绑定（要求请求的name与对应得javaBean的属性名称一致）
        System.out.println(user.toString());
        //来到员工列表页面
        //redirect：表示重定向到一个地址  ：/代表当前项目的路径
        //forward：表示转发到一个地址
        moniDao.save(user);
        return "redirect:/emps";
    }

    @RequestMapping("/bianji/{id}")
    public String bianji(@PathVariable("id") Integer id,Model model){
       user user2=moniDao.bianji();//假设user是根据id查到的值
       model.addAttribute("bianji",user2);
       return "addYuanGong";//回到添加员工界面，这里编辑和修改使用同一个html
    }

    @ResponseBody
    @RequestMapping(value = "/dog",method = RequestMethod.POST)
    public void insertDog(@RequestParam("name") String name, @RequestParam("age") Integer age,
                          HttpServletResponse response){
       int n=dogMapper.insertDog(name,age);
       if (n==1){
           try{
               response.setContentType("text/html");
               response.setCharacterEncoding("UTF-8");
               response.getWriter().write("成功了！");
           }catch (IOException e){
               e.printStackTrace();
           }
       }else {
           try{
               response.setContentType("text/html");
               response.setCharacterEncoding("UTF-8");
               response.getWriter().write("失败了！");
           }catch (IOException e){
               e.printStackTrace();
           }
       }
    }

    @RequestMapping("/d")
    public String d(){
        return "dogg";
    }

    @RequestMapping("/c")
    public String cat(){
        return "cat";
    }

    @ResponseBody
    @PostMapping("/cat")
    public void catInsert(@RequestParam("cName") String name,@RequestParam("cAge") Integer
                          age,HttpServletResponse response){
        int m=catMapper.insertCat(name,age);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        if (m==1){
            try{
                response.getWriter().write("成功了！");
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            try{
                response.getWriter().write("失败了！");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
