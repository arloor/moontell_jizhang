package com.arloor.zhang.mock;

import com.arloor.zhang.model.Record;

import java.util.LinkedList;
import java.util.List;

public class RecordMock {
    public static List<Record> mockRecords(){
        List<Record> records=new LinkedList<>();
        int recordId=101;
        recordId--;
        Record record=null;
        record=new Record(recordId,0,"默认账本","pay",true,"不说","就是不说",1200,"米什么好说的","2018","07","18","10:08");
        records.add(record);
        recordId--;
        record=new Record(recordId,0,"默认账本","earn",false,"不说","就是不说",10.5,"就是买衣服啦","2018","07","18","10:09");
        records.add(record);
        recordId--;
        record=new Record(recordId,0,"默认账本","earn",false,"饮食","食材",49.5,"羊肉","2018","07","18","15:09");
        records.add(record);
        recordId--;
        record=new Record(recordId,0,"默认账本","pay",false,"红包","亲戚",200,"没什么好说的","2018","07","19","08:09");
        records.add(record);
        return records;
    }

    public static List<Record> mockRecordsNewer(int maxId){
        List<Record> records=new LinkedList<>();
        Record record=null;
        if(maxId>110){
            return null;
        }
        int recordId=maxId+5;
        recordId--;
        record=new Record(recordId,0,"默认账本","pay",true,"不说","就是不说",1200,"米什么好说的","2018","07","18","10:08");
        records.add(record);
        recordId--;
        record=new Record(recordId,0,"默认账本","pay",false,"不说","就是不说",10.5,"就是买衣服啦","2018","07","18","10:09");
        records.add(record);
        recordId--;
        record=new Record(recordId,0,"默认账本","earn",false,"饮食","食材",49.5,"羊肉","2018","07","18","15:09");
        records.add(record);
        recordId--;
        record=new Record(recordId,0,"默认账本","earn",false,"红包","亲戚",200,"没什么好说的","2018","07","19","08:09");
        records.add(record);
        return records;
    }
    public static List<Record> mockRecordsElder(int minId){
        List<Record> records=new LinkedList<>();
        Record record=null;
        if(minId<=79){
            return null;
        }
        int recordId=minId;
        recordId--;
        record=new Record(recordId,0,"默认账本","pay",true,"不说","就是不说",1200,"米什么好说的","2018","07","18","10:08");
        records.add(record);
        recordId--;
        record=new Record(recordId,0,"默认账本","earn",false,"不说","就是不说",10.5,"就是买衣服啦","2018","07","18","10:09");
        records.add(record);
        recordId--;
        record=new Record(recordId,0,"默认账本","earn",false,"饮食","食材",49.5,"羊肉","2018","07","18","15:09");
        records.add(record);
        recordId--;
        record=new Record(recordId,0,"默认账本","earn",false,"红包","亲戚",200,"没什么好说的","2018","07","19","08:09");
        records.add(record);
        return records;
    }
}
