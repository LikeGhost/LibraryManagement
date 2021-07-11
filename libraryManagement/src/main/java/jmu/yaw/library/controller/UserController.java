package jmu.yaw.library.controller;

import jmu.yaw.library.po.User;
import jmu.yaw.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userInformation")
    @ResponseBody
    public ModelAndView userInformation(User user){
        ModelAndView mv=new ModelAndView();
        user=userService.findUserInformation(user);
        mv.addObject("user",user);
        mv.setViewName("userDetail");
        return mv;
    }
}
