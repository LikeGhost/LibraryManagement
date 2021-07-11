package jmu.yaw.library.service.impl;

import jmu.yaw.library.mapper.BookInformationMapper;
import jmu.yaw.library.mapper.BookMapper;
import jmu.yaw.library.mapper.ChineseLibraryClassificationMapper;
import jmu.yaw.library.po.Book;
import jmu.yaw.library.po.BookInformation;
import jmu.yaw.library.po.ChineseLibraryClassification;
import jmu.yaw.library.service.BookInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BookInformationServiceImpl implements BookInformationService {
    @Autowired
    private BookInformationMapper bookInformationMapper;

    @Autowired
    private ChineseLibraryClassificationMapper chineseLibraryClassificationMapper;

    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<Map<Object,Object>> allBookInformation() {
        bookInformationMapper.refreshAllBtId();
        return bookInformationMapper.queryAllBookInformation();
    }

    @Override
    public BookInformation queryAllBookByISBN(BookInformation bookInformation) {
        return bookInformationMapper.queryAllBookByISBN(bookInformation);
    }

    @Override
    public List<ChineseLibraryClassification> queryAllCLC() {
        return chineseLibraryClassificationMapper.queryAllCLC();
    }

    @Override
    public boolean addBookInformation(BookInformation bookInformation) {


        if(bookInformationMapper.queryBookInformationByISBN(bookInformation)!=null){
            return false;
        }
        else{
            bookInformationMapper.insertBookInformation(bookInformation);
            return true;
        }
    }

    @Override
    public int deleteBookInformation(BookInformation bookInformation) {
        if(bookInformation.getQuantity()==0){

        }
        return bookInformationMapper.deleteBookInformationByISBN(bookInformation);
    }

    @Override
    public int addBook(Book book,int count) {

        bookInformationMapper.updateQuantity(count,book.getIsbn());
        book.setBorrowStatus("canBorrow");
        for(int i=0;i<count;i++){
            bookMapper.insertBook(book);
        }
        return 1;
    }

    @Override
    public int deleteBookByBId(Book book) {
        bookMapper.deleteBook(book);
        bookInformationMapper.updateQuantity(-1,book.getIsbn());
        return 1;
    }
}
