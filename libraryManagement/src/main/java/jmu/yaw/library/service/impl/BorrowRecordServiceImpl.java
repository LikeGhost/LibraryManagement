package jmu.yaw.library.service.impl;

import jmu.yaw.library.mapper.BorrowRecordMapper;

import jmu.yaw.library.po.BorrowRecord;
import jmu.yaw.library.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {
    @Autowired
    private BorrowRecordMapper borrowRecordMapper;
    @Override
    public int refreshAllRecordStatusAndFinePrice() {

        borrowRecordMapper.refreshAllRecordStatusAndFinePrice();
        return 1;
    }


}
