package jmu.yaw.library.mapper;

import jmu.yaw.library.po.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
    User queryUserByUIdAndPassword(User user);
    User queryUserAndRole(User user);
}
