package com.zzm.constant;

public interface TokenConstant {

    /*7天(分钟为单位)*/
    int expiryDate = 10080;
    int expiryDate7days = 7;

    /*7天(秒为单位)*/
    int expiry7DateUnitSecond = 604800;

    /*30天(分钟为单位)*/
    int expiry30Date = 43200;

    /*365天(分钟为单位)*/
    int expiry365Date = 525600;

    /*365*10(分钟为单位),10年*/
    int expiry3650DateUnitMinute = 5256000;

    /*365*10(秒为单位),10年*/
    int expiry3650DateUnitSecond = 315360000;

    /*30天(秒为单位)*/
    int expiry30Dates = 2592000;
    int expiryDate30days = 30;

    /*30分钟*/
    int redisToken = 1800;

    /*1分钟*/
    int expiryDate1mins = 1;
    /*2分钟*/
    int expiryDate2mins = 2;
    int expiryDate2minsUnitSecond = 120;

    /*5分钟*/
    int expiryDate5mins = 5;
    int expiryDate5minsUnitSecond = 300;

    /*10分钟*/
    int expiryDate10mins = 10;
    int expiryDate10minsUnitSecond = 600;

    /*20分钟*/
    int expiryDate20mins = 20;
    int expiryDate20minsUnitSecond = 1200;

    /*30分钟*/
    int expiryDate30mins = 30;
    int expiryDate30minsUnitSecond = 1800;

    /*120分钟*/
    int expiryDate120mins = 120;
    int expiryDate120minsUnitSecond = 7200;

    /*6个月(秒为单位)*/
    int expiry6MonthUnitSecond = 15552000;

}
