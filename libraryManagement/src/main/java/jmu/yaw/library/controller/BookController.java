package jmu.yaw.library.controller;

import jmu.yaw.library.po.Book;
import jmu.yaw.library.po.BookInformation;
import jmu.yaw.library.po.ChineseLibraryClassification;
import jmu.yaw.library.service.BookInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookInformationService bookInformationService;


    @RequestMapping("allBookInformation")
    @ResponseBody
    public List<Map<Object,Object>> allBookInformation(){

        return bookInformationService.allBookInformation();
    }



    @RequestMapping("queryAllBookByISBN")
    @ResponseBody
    public BookInformation bookInformation(String isbn){
        BookInformation bookInformation=new BookInformation();
        bookInformation.setIsbn(isbn);
        bookInformation=bookInformationService.queryAllBookByISBN(bookInformation);
        return bookInformation;
    }

    @RequestMapping("queryAllCLC")
    @ResponseBody
    public List<ChineseLibraryClassification> queryAllCLC(){
        return bookInformationService.queryAllCLC();
    }

    @RequestMapping("addBookInformation")
    public ModelAndView addBookInformation(BookInformation bookInformation){
        ModelAndView mv=new ModelAndView();
        bookInformationService.addBookInformation(bookInformation);
        mv.setViewName("redirect:/addBookInformation.jsp");
        return mv;
    }
    @RequestMapping("deleteBookInformation")
    public ModelAndView deleteBookInformation(BookInformation bookInformation){
        ModelAndView mv=new ModelAndView();
        bookInformationService.deleteBookInformation(bookInformation);
        mv.setViewName("redirect:/allBookInformation.jsp");
        return mv;
    }

    @RequestMapping("addBook")
    public ModelAndView addBook(Book book,int count){
        ModelAndView mv=new ModelAndView();
        bookInformationService.addBook(book,count);
        mv.setViewName("redirect:/allBookInformation.jsp");
        return mv;
    }

    @RequestMapping("deleteBook")
    public ModelAndView deleteBook(Book book){
        ModelAndView mv=new ModelAndView();
        bookInformationService.deleteBookByBId(book);
        mv.setViewName("redirect:/allBookInformation.jsp");
        return mv;
    }


}
