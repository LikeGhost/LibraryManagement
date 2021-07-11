package jmu.yaw.library.service.impl;

import jmu.yaw.library.mapper.LibraryMapper;
import jmu.yaw.library.mapper.UserMapper;
import jmu.yaw.library.po.User;
import jmu.yaw.library.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public  User canLogin(User user) {
        if(user.getuId()!=null&&user.getPassword()!=null){
            user=userMapper.queryUserByUIdAndPassword(user);
        }
        return user;
    }
}
