package com.arloor.zhang.model;

import io.swagger.annotations.ApiModelProperty;

public class Record {

    private int recordId;
    private int bookId;
    private String bookName;
    @ApiModelProperty(notes = "pay:支出 earn:收入")
    private String type="pay";
    private boolean isPlaned;
    private String majorClass;
    private String minorClass;
    private double num;
    private String info="";
    private String year;
    private String month;
    private String date;
    private String time;


    public Record(int recordId, int bookId, String bookName, String type, boolean isPlaned, String majorClass, String minorClass, double num, String info, String year, String month, String date, String time) {
        this.recordId = recordId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.type = type;
        this.isPlaned = isPlaned;
        this.majorClass = majorClass;
        this.minorClass = minorClass;
        this.num = num;
        this.info = info;
        this.year = year;
        this.month = month;
        this.date = date;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isPlaned() {
        return isPlaned;
    }

    public void setPlaned(boolean planed) {
        isPlaned = planed;
    }

    public String getMajorClass() {
        return majorClass;
    }

    public void setMajorClass(String majorClass) {
        this.majorClass = majorClass;
    }

    public String getMinorClass() {
        return minorClass;
    }

    public void setMinorClass(String minorClass) {
        this.minorClass = minorClass;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
