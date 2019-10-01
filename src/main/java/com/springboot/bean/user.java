package com.springboot.bean;

public class user {
    private Integer id;
    private String name;
    private Integer age;
    private dog dog;
    private Integer dId;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public user(Integer id,String name, Integer age, com.springboot.bean.dog dog) {
        this.name = name;
        this.age = age;
        this.dog = dog;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    @Override
//    public String toString() {
//        return "user{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", dog=" + dog +
//                '}';
//    }


    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dog=" + dog +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public dog getDog() {
        return dog;
    }

    public void setDog(dog dog) {
        this.dog = dog;
    }

    public user(){

    }

    public user(String name, Integer age, dog dog) {
        this.name = name;
        this.age = age;
        this.dog = dog;
    }
}
