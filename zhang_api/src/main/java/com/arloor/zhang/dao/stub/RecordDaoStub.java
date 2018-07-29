package com.arloor.zhang.dao.stub;

import com.arloor.zhang.dao.RecordDao;
import com.arloor.zhang.mock.RecordMock;
import com.arloor.zhang.model.Record;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecordDaoStub implements RecordDao {
    @Override
    public List<Record> getSomeRecords(String id, String openId, String year,String month) {
        return RecordMock.mockRecords();
    }

    @Override
    public List<Record> getRecordsNewerThanSomeId(String openId, String year,String month, String bookId, int maxId) {
        return RecordMock.mockRecordsNewer(maxId);
    }

    @Override
    public List<Record> getRecordsElderThanSomeId(String openId, String year,String month, String bookId, int minId) {
        return RecordMock.mockRecordsElder(minId);
    }
}
