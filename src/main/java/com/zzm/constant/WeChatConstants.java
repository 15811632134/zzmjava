package com.zzm.constant;

public class WeChatConstants {
    /**微信支付统一下单接口*/
    public static final String unifiedOrderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";


    public static String SUCCESSxml = "<xml> \r\n" +
            "\r\n" +
            "  <return_code><![CDATA[SUCCESS]]></return_code>\r\n" +
            "   <return_msg><![CDATA[OK]]></return_msg>\r\n" +
            " </xml> \r\n" +
            "";
    public static String ERRORxml =  "<xml> \r\n" +
            "\r\n" +
            "  <return_code><![CDATA[FAIL]]></return_code>\r\n" +
            "   <return_msg><![CDATA[invalid sign]]></return_msg>\r\n" +
            " </xml> \r\n" +
            "";
}
