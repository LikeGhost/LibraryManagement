package jmu.yaw.library.service;

import jmu.yaw.library.po.Book;
import jmu.yaw.library.po.BorrowRecord;
import jmu.yaw.library.po.User;

import java.util.List;

public interface BorrowService {
    int borrowBook(User user, Book book);
    List<BorrowRecord> borrowRecordByUser(User user);
    int returnBook(User user,Book book);

    BorrowRecord queryBorrowRecordByBrId(BorrowRecord borrowRecord);

    int changeBorrowRecord(BorrowRecord borrowRecord);
    int payFinePrice(BorrowRecord borrowRecord,Book book);

}
