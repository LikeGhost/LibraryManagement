package jmu.yaw.library.service.impl;

import jmu.yaw.library.mapper.UserMapper;
import jmu.yaw.library.po.User;
import jmu.yaw.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserInformation(User user){
        return userMapper.queryUserAndRole(user);
    }
}
