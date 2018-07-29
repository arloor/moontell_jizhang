package com.arloor.zhang.controller;

import com.arloor.zhang.dao.RecordDao;
import com.arloor.zhang.model.Record;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/records")
@Api(value = "records",description = "账本记录 增删改查")
public class RecordController {

    @Autowired
    RecordDao recordDao;


    @ApiOperation(value = "根据参数查询账本记录",response = Record.class)
    @GetMapping("")
    public List<Record> queryRecords(
            @ApiParam(value = "用户openId",required = true) @RequestParam String openId,
            @ApiParam(value = "2018这种",required = true) @RequestParam String year,
            @ApiParam(value = "08这种",required = true) @RequestParam String month,

            @ApiParam(value = "账本唯一Id",required = true) @RequestParam String bookId,
            @ApiParam(value = "用于分页") @RequestParam(required = false,defaultValue = "0") int minId,
            @ApiParam(value = "用于分页") @RequestParam(required = false,defaultValue = "0") int maxId,
            @ApiParam(value = "查询更新/旧 new/old") @RequestParam(required = false) String option
    ){
        //第一次查询
        if(option==null){
//            return null;
            return recordDao.getSomeRecords(openId,year,month,bookId);
        }
        else if(option.equals("new")){
            return recordDao.getRecordsNewerThanSomeId(openId,year,month,bookId,maxId);
        }
        else if(option.equals("old")){
            return recordDao.getRecordsElderThanSomeId(openId,year,month,bookId,minId);

        }
        return null;
    }

}
