package com.example.bootdemo.service;


import com.example.bootdemo.dao.UserDao;
import com.example.bootdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

/*
    @Override
    public User selectUserByUsername(String username) {
        return userDao.selectUserByUsername(username);
    }
*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.selectUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("账户不存在！");
        }
        user.setRoles(userDao.getUserRolesByUid(user.getId()));
        return user;
    }
}
