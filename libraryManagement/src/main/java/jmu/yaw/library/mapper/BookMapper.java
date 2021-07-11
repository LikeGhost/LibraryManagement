package jmu.yaw.library.mapper;

import jmu.yaw.library.po.Book;
import jmu.yaw.library.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    int updateBorrowStatus(Book book);
    Book queryBookByBId(Book book);
    List<Book> queryBookByISBN(Book book);

    int insertBook(Book book);

    int deleteBook(Book book);
}
