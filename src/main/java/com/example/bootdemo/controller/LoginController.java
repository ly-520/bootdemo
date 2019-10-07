package com.example.bootdemo.controller;

import com.example.bootdemo.common.Result;
import com.example.bootdemo.pojo.User;
import com.example.bootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;


    @CrossOrigin
    @RequestMapping("api/login")
    @ResponseBody
    public Result testlogin(@RequestBody User user){
        System.out.println(user.getUsername()+":"+user.getPassword());
     /*   User user2=userService.selectUserByUsername(user.getUsername());
        if(user2 !=null && user.getUsername().equals(user2.getUsername()) && user.getPassword().equals(user2.getPassword())){
            return new Result(200);
        }*/
        return new Result(400);
    }
}
