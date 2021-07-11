package jmu.yaw.library.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jmu.yaw.library.po.Library;
import jmu.yaw.library.po.User;
import jmu.yaw.library.service.LibraryService;
import jmu.yaw.library.service.LoginService;
import jmu.yaw.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @Autowired
    private LibraryService libraryService;
    @RequestMapping("/canLogin")
    @ResponseBody
    public ModelAndView canLogin(HttpSession session, User user, Library library){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("redirect:/");
        user=loginService.canLogin(user);
        library=libraryService.queryLibraryByLName(library);
        if(user!=null) {
            user=userService.findUserInformation(user);

            if(user.getrId()>2&&user.getrId()<6||user.getrId()==1) {
                mv.setViewName("redirect:/userPage.jsp");
            }
            else if(user.getrId()==2){
                mv.setViewName("redirect:/adminPage.jsp");
            }
        }
        else{
            user=new User();
            user.setuId("-1");
        }
        session.setAttribute("user",user);
        session.setAttribute("role",user.getRole());
        session.setAttribute("library",library);
        return mv;

    }

    @RequestMapping("/logout")
    @ResponseBody
    public ModelAndView logout(HttpSession session){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("redirect:/");
        session.removeAttribute("user");
        session.removeAttribute("role");
        session.removeAttribute("library");
        return mv;

    }
}
