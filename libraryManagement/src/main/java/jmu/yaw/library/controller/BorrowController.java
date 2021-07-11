package jmu.yaw.library.controller;


import jmu.yaw.library.po.Book;
import jmu.yaw.library.po.BorrowRecord;
import jmu.yaw.library.po.User;
import jmu.yaw.library.service.BorrowRecordService;
import jmu.yaw.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private BorrowRecordService borrowRecordService;
    @RequestMapping("/borrowBook")
    public ModelAndView borrowBook(User user,Book book){
        ModelAndView mv=new ModelAndView();

        borrowService.borrowBook(user,book);
        mv.setViewName("redirect:/allBookInformation.jsp");
        return mv;
    }

    @RequestMapping("/borrowRecord")
    @ResponseBody
    public Map<Object,Object> borrowRecord(User user){

        List<BorrowRecord> list=borrowService.borrowRecordByUser(user);
        Map<Object,Object> map=new HashMap<>();
        map.put("code",200);
        map.put("list",list);
        return map;
    }
    @RequestMapping("/returnBook")
    public  ModelAndView returnBook(User user,Book book){
        ModelAndView mv=new ModelAndView();
        borrowService.returnBook(user,book);
        mv.setViewName("redirect:/allBorrowRecord.jsp");
        return mv;

    }
    @RequestMapping("/queryBorrowRecordByBrId")
    @ResponseBody
    public BorrowRecord queryBorrowRecordByBrId(BorrowRecord borrowRecord){
        return borrowService.queryBorrowRecordByBrId(borrowRecord);

    }

    @RequestMapping("/changeBorrowRecord")
    public ModelAndView changeBorrowRecord(BorrowRecord borrowRecord){
        ModelAndView mv=new ModelAndView();
        borrowService.changeBorrowRecord(borrowRecord);
        mv.setViewName("redirect:/allBorrowRecord.jsp");
        return  mv;
    }
    @RequestMapping("refreshAllRecordStatusAndFinePrice")
    public void refreshAllRecordStatusAndFinePrice(){
       borrowRecordService.refreshAllRecordStatusAndFinePrice();
    }

    @RequestMapping("payFinePrice")
    public ModelAndView payFinePrice(BorrowRecord borrowRecord,Book book){
        ModelAndView mv=new ModelAndView();

        borrowService.payFinePrice(borrowRecord,book);

        mv.setViewName("redirect:/allBorrowRecord.jsp");
        return mv;
    }

}
