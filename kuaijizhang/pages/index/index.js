// pages/index/index.js
const app = getApp();
var util = require("../../utils/util.js");

Page({

  /**
   * 页面的初始数据
   */
  data: {
    openId: "notSet",
    records: null,
    total: 4560,
    hasRecord:true
  },
  longPressCard: function(e) {
    console.log(e);
    wx.showToast({
      title: '提示是否进行删除',
      duration: 500
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var now = new Date;
    var year = util.formatYear(now);
    var month = util.formatMonth(now);
    this.setData({
      year: year,
      month: month
    })

    if (app.globalData.openId) {
      this.setData({
        openId: app.globalData.openId
      })
      console.log("index的openId", this.data.openId);
      this.load();
    } else {
      //获取openId是网络请求，在这里设置app的callback。
      //注意：这里的this其实是index，而不是app
      app.openIdReadyCallback = res => {
        this.setData({
          openId: res.data.openid
        })
        console.log("callback 设置index的openId", this.data.openId);
        this.load();
      }
    }
  },



  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },


  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {
  if(this.data.records==null){
    this.load();
    return;
  }
    this.loadNew();
  },


  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {
    if (this.data.records == null) {
      this.load();
      return;
    }
    this.loadOld();
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  },


  load: function () {
    wx.showLoading({
      title:"拼命加载中"
    })
    var that = this;
    console.log("测试是不是index", this.data.openId)
    
    var varUrl = app.apiBase + "/records?openId=" + this.data.openId + "&year=" + this.data.year + "&month=" + this.data.month + "&bookId=0";
    console.log(varUrl)
    wx.request({
      url: varUrl,
      success: function (res) {
        console.log("查询到的记录", res.data);
        if (res.data.length == 0) {
          that.setData({
            hasRecord:false
          })
          wx.hideLoading();
          return;
        }
        that.setData({
          records: res.data,
          maxId: res.data[0].recordId,
          minId: res.data[res.data.length - 1].recordId
        })
        wx.hideLoading();
      }
    })
  },
  loadNew: function () {
    // wx.showLoading({
    //   title: "拼命加载中"
    // })
    var that = this
    var varUrl = app.apiBase + "/records?openId=" + this.data.openId + "&year=" + this.data.year + "&month=" + this.data.month + "&option=new&maxId=" + this.data.maxId + "&bookId=0"

    wx.request({
      url: varUrl,
      success: function (res) {
        if (res.data.length == 0) {
          // wx.hideLoading()
          wx.stopPullDownRefresh();
          wx.showToast({
            title: '没有更新的啦~',
            image:"/icons/tongzhi.png",
            duration: 1000
          })
          return;
        }
        console.log("查询到的记录", res.data);
        var records = res.data.concat(that.data.records);
        that.setData({
          records: records,
          maxId: res.data[0].recordId
        })
        console.log("records:", that.data.maxId, "--", that.data.minId);
        // wx.hideLoading()
        wx.stopPullDownRefresh()
      }
    })
  },

  loadOld: function () {
    wx.showLoading({
      title: "拼命加载中"
    })
    var that = this
    var varUrl = app.apiBase + "/records?openId=" + this.data.openId + "&year=" + this.data.year + "&month=" + this.data.month + "&option=old&minId=" + this.data.minId + "&bookId=0"

    wx.request({
      url: varUrl,
      success: function (res) {
        if (res.data.length == 0) {
          wx.hideLoading()
          wx.stopPullDownRefresh();
          wx.showToast({
            title: '没有更旧的啦~',
            image: "/icons/tongzhi.png",
            duration:1000
          })
          return;
        }
        console.log("查询到的记录", res.data);
        var records = that.data.records.concat(res.data);
        that.setData({
          records: records,
          minId: res.data[res.data.length - 1].recordId
        })
        console.log("records:", that.data.maxId, "--", that.data.minId);
        wx.hideLoading()
      }
    })
  }
})