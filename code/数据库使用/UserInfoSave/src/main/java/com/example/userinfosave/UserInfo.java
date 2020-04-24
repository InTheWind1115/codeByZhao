package com.example.userinfosave;

public class UserInfo {
    private int id;
    private String username;
    private String password;
    private String sex;
    private String age;
    public UserInfo(int id,String username,String password,String sex,String age)
    {
        this.id=id;
        this.username=username;
        this.password=password;
        this.sex=sex;
        this.age=age;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public String toString()
    {
        return "userInfo{"+"id="+id+",username="+username+",password="+password+",sex"+sex+",age="+age;
    }
}
