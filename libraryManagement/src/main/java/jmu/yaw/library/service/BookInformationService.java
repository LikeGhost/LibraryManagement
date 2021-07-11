package jmu.yaw.library.service;

import jmu.yaw.library.mapper.BookInformationMapper;
import jmu.yaw.library.po.Book;
import jmu.yaw.library.po.BookInformation;
import jmu.yaw.library.po.ChineseLibraryClassification;

import java.util.List;
import java.util.Map;


public interface BookInformationService {

    List<Map<Object,Object>> allBookInformation();

    BookInformation queryAllBookByISBN(BookInformation bookInformation);

    List<ChineseLibraryClassification> queryAllCLC ();

    boolean addBookInformation(BookInformation bookInformation);

    int deleteBookInformation(BookInformation bookInformation);

    int addBook(Book book,int count);

    int deleteBookByBId(Book book);
}
