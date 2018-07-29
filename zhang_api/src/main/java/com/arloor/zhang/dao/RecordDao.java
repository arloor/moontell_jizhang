package com.arloor.zhang.dao;

import com.arloor.zhang.model.Record;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecordDao {
    List<Record> getSomeRecords(String id, String openId, String year,String month);

    List<Record> getRecordsNewerThanSomeId(String openId, String year,String month, String bookId, int maxId);

    List<Record> getRecordsElderThanSomeId(String openId, String year,String month, String bookId, int minId);
}
