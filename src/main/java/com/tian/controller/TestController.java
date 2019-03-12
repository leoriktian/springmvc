package com.tian.controller;

import com.tian.object.Admin;
import com.tian.object.User;
import com.tian.object.UserListForm;
import com.tian.object.UserMapForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: tyq
 * @Date: 2019/3/11 13:08
 */
@Controller
public class TestController {

    /*基本类型*/
    //todo http://localhost:8080/baseType.do?xage=10
    @RequestMapping(value="baseType.do")
    @ResponseBody
    public String baseType(@RequestParam(value = "xage") int age) {

        return "age:" + age;
    }

    /* 包装类型 */
    //todo http://localhost:8080/baseType2.do?age=10
    @RequestMapping(value="baseType2.do")
    @ResponseBody
    public String baseType( Integer age) {

        return "age:" + age;
    }

    /* 数组类型 */
    //todo http://localhost:8080/array.do?name=tom&name=jim&name=lucy
    @RequestMapping("/array.do")
    @ResponseBody
    public String array(String[] name){

        StringBuilder sbf = new StringBuilder();
        for (String item : name) {
            sbf.append(item).append("  ");
        }

        return sbf.toString();
    }

    /*简单对象和多层级对象绑定*/
   //todo http://localhost:8080/object.do?name=tom&age=20
    //todo http://localhost:8080/object.do?name=tom&age=20&contactInfo.phone=10086
    @RequestMapping("/object.do")
    @ResponseBody
    public String object(User user){

        return user.toString();
    }

    /*同属性的多对象绑定*/
    //todo http://localhost:8080/object.do?user.name=tom&age=20&admin.name=lucy
    @RequestMapping("/object1.do")
    @ResponseBody
    public String object1(User user,Admin admin){

        return user.toString()+"  "+admin.toString();
    }
    //通过注解@InitBinder("user")的辅助方法来实现获取各自绑定的属性
    @InitBinder("user")
    public void initUser(WebDataBinder binder){
        binder.setFieldDefaultPrefix("user.");
    }

    @InitBinder("admin")
    public void initAdmin(WebDataBinder binder){
        binder.setFieldDefaultPrefix("admin.");
    }


    /*list数据绑定*/
    //todo http://localhost:8080/list.do?users[0].name=tom&users[1].name=lucy
    //TODO http://localhost:8080/list.do?users[0].name=tom&users[20].name=lucy  只有第一个和最后一个有值,所以请求索引一定要是连续的否则浪费资源
    @RequestMapping("/list.do")
    @ResponseBody
    public String list(UserListForm userListForm ){

        return "listSize:" + userListForm.getUsers().size()+ "  "+ userListForm.toString();
    }

    /*map数据绑定*/
    //TODO http://localhost:8080/map.do?users['X'].name=tom&users['X'].age=10&&users['Y'].name=lucy&users['Y'].age=20
    @RequestMapping(value = "map.do")
    @ResponseBody
    public String map(UserMapForm userMapForm ){

        return userMapForm.toString();
    }

    /*json数据绑定*/
    //    {
//           "name": "Jim",
//            "age": 16,
//            "contactInfo": {
//                "address": "beijing",
//                "phone": "10010"
//              }
//        }
    //application/json
    @RequestMapping(value = "json.do")
    @ResponseBody
    public String json(@RequestBody User user ){

        return user.toString();
    }

    /*xml数据绑定*/
    //<?xml version="1.0" encoding="UTF-8" ?>
//    <admin>
//      <name>Jim</name>
//      <age>16</age>
//    </admin>
    //application/xml
    @RequestMapping(value = "xml.do")
    @ResponseBody
    public String xml(@RequestBody Admin admin ){

        return admin.toString();
    }






}
