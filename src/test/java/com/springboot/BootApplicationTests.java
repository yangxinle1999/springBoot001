package com.springboot;

import com.springboot.bean.person;
import com.springboot.mapper.dogMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {

    @Autowired
    private person person;
    @Autowired
    private dogMapper dogMapper;
    @Test
    public void contextLoads() {
        System.out.println(person);
    }

    @Test
    public void getUserAndDog(){
        System.out.println(dogMapper.selectUser(2));
    }

}
