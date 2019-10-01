package com.springboot.dao;

import com.springboot.bean.dog;
import com.springboot.bean.user;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class moniDao {

    static List<user> userList=new ArrayList<>();//将userList声明为静态的，随时改变
    dog dog1=new dog("huahua",2);
    user user1=new user(1,"小明",20,dog1);
    dog dog2=new dog("lala",1);
    user user2=new user(2,"小红",22,dog2);
    public List<user> getAllPerson(){
        if (!userList.contains(user1)) {//判断容器中是否已经包含user1，若有就不再加入了
            userList.add(user1);
            userList.add(user2);
        }
        return userList;
    }
    public void save(user user){
        userList.add(user);
    }

    public user bianji(){//模拟数据库，进行编辑界面的界面回显
        dog dog3=new dog("狗狗",3);
        user user1=new user(3,"花花",20,dog3);
        return user1;
    }

//    public List<user> getAdd(user user){
//        save(user);
//        return userList;
//    }

}
