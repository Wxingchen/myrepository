package cn.taoqi.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: SSM001
 * @description:
 * @author:
 * @create: 2020-03-28 22:36
 **/
public class User implements Serializable {
    private String username;
    private Integer age;
    private Date birthday;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
