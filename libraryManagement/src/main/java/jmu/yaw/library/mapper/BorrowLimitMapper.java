package jmu.yaw.library.mapper;

import jmu.yaw.library.po.BorrowLimit;
import jmu.yaw.library.po.BorrowRecord;

public interface BorrowLimitMapper {
    BorrowLimit queryBorrowLimit(BorrowRecord borrowRecord);
}
