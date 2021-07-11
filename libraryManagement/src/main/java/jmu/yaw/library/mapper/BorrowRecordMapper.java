package jmu.yaw.library.mapper;

import jmu.yaw.library.po.BorrowRecord;
import jmu.yaw.library.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BorrowRecordMapper {

    int insertBorrowRecord(BorrowRecord borrowRecord);
    List<BorrowRecord> queryBorrowRecordByUId(User user);
    int updateRecordStatus(BorrowRecord borrowRecord);

    BorrowRecord queryBorrowRecordByBrId(BorrowRecord borrowRecord);

    int updateReturnTimeAndRecordStatusByBrId(BorrowRecord borrowRecord);
    int refreshAllRecordStatusAndFinePrice();
    int subFinePrice(BorrowRecord borrowRecord);

    int updateRecordStatusByBrId(BorrowRecord borrowRecord);
}
