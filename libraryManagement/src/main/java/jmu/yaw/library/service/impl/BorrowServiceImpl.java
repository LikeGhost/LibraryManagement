package jmu.yaw.library.service.impl;

import jmu.yaw.library.mapper.*;
import jmu.yaw.library.po.*;
import jmu.yaw.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRecordMapper borrowRecordMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookInformationMapper bookInformationMapper;

    @Autowired
    private BorrowLimitMapper borrowLimitMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public int borrowBook(User user, Book book) {


        book.setBorrowStatus("borrowed");
        bookMapper.updateBorrowStatus(book);
        book=bookMapper.queryBookByBId(book);

        BookInformation bookInformation=new BookInformation();
        bookInformation.setIsbn(book.getIsbn());

        BorrowRecord borrowRecord=new BorrowRecord();
        borrowRecord.setuId(user.getuId());
        borrowRecord.setbId(book.getbId());
        BorrowLimit borrowLimit=borrowLimitMapper.queryBorrowLimit(borrowRecord);


        Date borrowTime=new Date();
        Calendar calendar =new GregorianCalendar();
        calendar.setTime(borrowTime);
        calendar.add(Calendar.DATE,(borrowLimit.getBorrowDay()));
        Date returnTime=calendar.getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        borrowRecord.setBorrowTime(sdf.format(borrowTime));
        borrowRecord.setReturnTime(sdf.format(returnTime));

        borrowRecord.setRecordStatus("running");
        borrowRecordMapper.insertBorrowRecord(borrowRecord);

        return 1;
    }

    @Override
    public List<BorrowRecord> borrowRecordByUser(User user) {
        borrowRecordMapper.refreshAllRecordStatusAndFinePrice();
        user=userMapper.queryUserAndRole(user);
        if(user.getRole().getrId()==2){
            user.setuId(null);
        }
        List<BorrowRecord> list=borrowRecordMapper.queryBorrowRecordByUId(user);
        return list;
    }

    @Override
    public int returnBook(User user, Book book) {
        book.setBorrowStatus("canBorrow");
        bookMapper.updateBorrowStatus(book);
        BorrowRecord borrowRecord=new BorrowRecord();
        borrowRecord.setuId(user.getuId());
        borrowRecord.setbId(book.getbId());
        borrowRecord.setRecordStatus("stop");
        return borrowRecordMapper.updateRecordStatus(borrowRecord);
    }

    @Override
    public BorrowRecord queryBorrowRecordByBrId(BorrowRecord borrowRecord) {

        return borrowRecordMapper.queryBorrowRecordByBrId(borrowRecord);
    }

    @Override
    public int changeBorrowRecord(BorrowRecord borrowRecord) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date returnTime= null;
        try {
            returnTime = sdf.parse(borrowRecord.getReturnTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date nowDate=new Date();
        if(returnTime.compareTo(nowDate)>0){
            borrowRecord.setRecordStatus("running");
        }
        else{
            borrowRecord.setRecordStatus("outTime");
        }
        borrowRecordMapper.updateReturnTimeAndRecordStatusByBrId(borrowRecord);
        return 1;
    }

    @Override
    public int payFinePrice(BorrowRecord borrowRecord,Book book) {
        book.setBorrowStatus("canBorrow");
        bookMapper.updateBorrowStatus(book);
        borrowRecordMapper.subFinePrice(borrowRecord);
        borrowRecord.setRecordStatus("stop");
        borrowRecordMapper.updateRecordStatusByBrId(borrowRecord);
        return 1;
    }
}
