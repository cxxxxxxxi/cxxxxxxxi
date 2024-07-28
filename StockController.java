package com.controller;

import com.po.ResultTo;
import dao.AbstractDaoImpl;
import org.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockController {
    String driver ="com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://cent1:3306/test";
    String user = "root2";
    String pass = "123Aa!ab";
    AbstractDaoImpl abstractDao = new AbstractDaoImpl(driver,url,user,pass);
    /**
     * @param startDate 开始查询的时间位置  20231231
     * @param endDate   结束查询的时间位置  20240713
     * @return   返回到页面的是数据
     */
    public List getAir(String targetDate)
    {

        return abstractDao.getMaps( "air", "*",  "date LIKE '" + targetDate + "'");
    }

    public List getAirin(String startDate,String endDate)
    {

        return abstractDao.getMaps( "air", "*",  "date >= '"+startDate+"'  and date <= '"+endDate+"'");
    }
}



//select table_stock.yyyymmdd table_stock_yyyymmdd,table_stock.openrice table_stock_openrice,table_stock.closePrice table_stock_closePrice,table_stock.lowPrice table_stock_lowPrice,table_stock.hiPrice table_stock_hiPrice,table_stock.zhangfu table_stock_zhangfu,table_stock.gpName table_stock_gpName,table_stock.volume table_stock_volume from table_stock where yyyymmdd > 19990101 and yyyymmdd < 20240717 and gpName='张家界' limit 0,100