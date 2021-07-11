package jmu.yaw.library.service;

import jmu.yaw.library.po.User;

public interface LoginService {
    User canLogin(User user);
}
