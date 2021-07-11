package jmu.yaw.library.mapper;

import jmu.yaw.library.po.Book;
import jmu.yaw.library.po.BookInformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookInformationMapper {

    List<Map<Object,Object>> queryAllBookInformation();

    BookInformation queryAllBookByISBN(BookInformation bookInformation);


    int subBookInformationQuantity(BookInformation bookInformation);

    int insertBookInformation(BookInformation bookInformation);

    BookInformation queryBookInformationByISBN(BookInformation bookInformation);

    int deleteBookInformationByISBN(BookInformation bookInformation);

    int updateQuantity(@Param("count") int count,  @Param("isbn") String isbn);

    int refreshAllBtId();
}
