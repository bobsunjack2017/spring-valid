package com.demo4.controller;

import com.demo4.valid.NotEmpty2;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

public class Subscriber  implements Serializable {

    @NotEmpty2(field = "password", message = "{password.empty.error}")
    private String name2;

    @Length(min=2, max=30, message = "{user.name.length.illegal}")
    private String name;

    @NotEmpty(groups = {SubscriberGroup.Add.class})
    @Email
    private String email;

    @Min(13) @Max(110)
    private Integer age;


    @Size(min = 5, max = 20, message = "{user.name.length.illegal}")
    private String one;


    @Size(min=10)
    private String phone;

    @NotNull(message = "{NotNull.Subscriber.gender}")
    private String gender;

    @DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull
    @Past
    private Date birthday;

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

}
