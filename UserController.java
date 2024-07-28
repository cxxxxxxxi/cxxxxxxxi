package com.controller;

import com.po.ResultTo;
import dao.AbstractDaoImpl;
import org.MultipartFile;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {
    String driver ="com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String pass = "Ljj20040324";
    AbstractDaoImpl abstractDao = new AbstractDaoImpl(driver,url,user,pass);
    public Boolean register(String username, String password, String phone, MultipartFile file){
        String path = this.getClass().getResource("/").getPath()+"web/";
        File folder = new File(path);
        if(!folder.exists()){
            folder.mkdirs();
        }
        file.transferTo(new File(path+username+".jpg"));
        file.transferTo(new File(path));

        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        map.put("phone",phone);
        map.put("header",username+".jpg");
        return abstractDao.insert("user",map);
    }

    public ResultTo login(String username, String password){
        Map user =  abstractDao.getMap("user","*","username='"+username+"' and password='"+password+"'");
        ResultTo resultTo = new ResultTo();  //存数据
        if(user==null){
            resultTo.value=null;
            resultTo.msg = "登录失败";
        }else {
            resultTo.value =user;
            resultTo.msg = "登录成功";
        }
        return resultTo;
    }
}
