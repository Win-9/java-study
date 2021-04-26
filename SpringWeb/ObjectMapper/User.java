package com.example.objectmapper;

public class User {
    private String name;
    private int age;


    public User(){
        this.name=null;
        this.age=0;
    }
    public User(String name,int age){
        this.name=name;
        this.age=age;
    }
    @Override
    public String toString() {
        return "com.example.objectmapper.User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
