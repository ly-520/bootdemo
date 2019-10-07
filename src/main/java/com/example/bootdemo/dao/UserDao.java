package com.example.bootdemo.dao;

import com.example.bootdemo.pojo.Role;
import com.example.bootdemo.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    User selectUserByUsername(@Param("username") String username);

    List<Role> getUserRolesByUid(@Param("id") Integer id);
}
