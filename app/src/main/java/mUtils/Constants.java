package mUtils;

/**
 * Created by Administrator on 2016/10/26.
 */
public class Constants {

    //读写
    public static final int WRITE_READ_EXTERNAL_CODE = 0x01;
    //照相
    public static final int CAMERA_CODE = 0x02;
    //电话
    public static final int CALL_PHONE_CODE = 0x03;
    //短信
    public static final int SEM_MESSAGE_CODE = 0x04;
    //手机信息
    public static final int PHONE_STATE_CODE = 0x05;
    //微信APPID
    public static final String APP_ID = "wx0cdac55753fcd5a9";
    //微信Sign
    public static final String WxSign = "3e2789e4cbaa2ad9c85eaf06a2839365";
   // 微信APP_SERCET
    public static  final String APP_SERCET = "0e5cb5ef8401894ab46c945139792f7c";
    //支付宝APPID
    public static final String AliPay_APPID = "2017042106869800";
    //支付宝RSA2
    public static final String RSA2_PRIVATE="";
    public static final String QQApp_ID = "1106008988";
//    public static final String RSA2_PRIVATE = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCMV/4LfFvXh1TFr/FNw/rK4GAJqltid1SZxgEjoleE6YWD0QffYKk8fbnn/iVWoTxKPzQd1uy+Dy3u6g7ZVpIWBOceMYpTtUBfI+Dbdpvjhidgc81kaRxZobu88k7y0SFxvdQEPNOIS/6EHf14OUX4CveNPFRaLZZpULxXn8HbjVkM75WDZaDe3wRNP2dOlH89Y8q1lF/vDZZ2IG4qXCSInpK99Z6lmZP7wyKn8Ly1CWM4k537K2FFTNP3Vw1LaBAnab99k53jIeRgkWwrOcZxzdcWSKGo7epHdm0/0ROiUUP8YJc0E3ZfPxkks4IfYnmL5xjhanx16AQOgqYkxb2XAgMBAAECggEAVl5gjZj+vGkglnhsvDr7wJbNA6W/j514hxn/4Xoq+jTsYe7mNWY7QGrvWgJh4Cph/B9hZ2u5Tk3xKrMIaGCKjtp9kWtTgaht8R8XZnhb/220FfuuTzkQpWiPLPzB8VUai/ES5Xi5hYufGpeKQc6dbMTzDAwwrT6Y7j8taY97si0kw7XugnfMTOPcMtOVgm41YW4VM9cy6yQ2p3e125of/toere5XHdKNG1sEqkE2QIf+aJpx7SEMRBQSQqM/F68s4/7hkIhXAHajfgsIec6NL5DOuIyBlLhNcZD2+c0+xYqx4YfhAH5QqOwt2NPs6ezZv+3MBHmcv+TjyziUj6bRwQKBgQDMekcByOq56gIJ5WQHEw+E2ak6+HY6DWhkiNM+ci8eoNXIPJ2fyA9txDHocvmKRINFA195KhBqEhyy/qseplO1RdiL3DPGnaOxT47ooAk2aBn9kHGAVZKzdhlv9tII1b5lwYPZFmaxs1+hzZroYzQhJ/lN2LaKeNWAyUWRiT2t7wKBgQCvtMo6qQxj+AksiE5JHY/YjEdhCSF02kM02UeeJEiSrsWiD1BlxF5Ijn/V6USujn6PCLDdgEW82SfPyOEjGxmOYDXXWBa/hwMjUh4FEw3JJns3lNmuVG+jhdcbvBWcDw8TeESLFMR/+Q0MN2ynQX0n11NzuzRbPi91Yb+VLWWS2QKBgQCAK8WGoOJBVyWf/mIM7S21IJqrlELHcNAW9I01f215zWcz9Ir5NPY239xI0IkK2pdOEyctU+imFGRY7rlkpO2jmvx57rWlsfqBklUKDAa6S9a+0mPTBdDHHSgkvpo5X4HRVtPGp/wHN2Cik7aeJFDw15W17jm94rAx4ffxmg1HkQKBgQCZRirLtUA7zNmj4Vv5aDJdgzGZMm/fEa9i4NAa4if03UVGM/m8bOqafMSDhDQH2gIJIFm5P/aV4RFbry7GgxNuIfuV2SAu/8X6/910K8Tw3gLK36xs6PdiPJUDerWXJ4PNRjL06K7pvAZny8matgRJxwrjgEERyinDIHwR1EIxMQKBgDIPXsdOdgeDHYRxi0EXtAzgf4XdVK1W6WruBMSTC5w6CZ1H/k/0TzmM/w9mtfpX+JjZmeg2Fn7FN2ISPr/RQhmwBFv/cLwYO7vELMyWHJHA1vQXEYt3tefryymMMcuV4vyT8PjXDJSKTVTVnd6R5lvYgs7Zpu5TnHE4YSfFl7lm";
   //支付宝RSA1
    public static final String RSA_PRIVATE = "MIIEowIBAAKCAQEAuau/6rEbYtNrdvetJpczizQqffWHmlskX9Tg8ppcImFcX4KigSF9llfjc7NpAWme4BDf8tP1+nRg/5y+3eyF3NrkEQh/b8Na8zfeKg6MK8LbKp/g5zetsYQp18iNCKhxGHESLHePsXYHSZdgfJVsy4ynO4NxmBnyyiutdTcj8PAfPPs4XDbKOJ7KKYvom7Wcn66IrYijknZebmfUkbUlg0iYhN2Zo/oRQifRr/h53gowEBo3mqQz4/Y+fqCc5maqZSWOUAox8djepwz63I8lo50Kem3VMViHraReQaMSXSMI+dl8cUPCF7uu2PTlJDkh3ogSSSBngBak6SqI/yGyBQIDAQABAoIBACPFNPowGMiXVrLa0J8IrkN5T15o+TEBsiZMSvIyTuHIxBUag9hA7YMTd5yIyggdoyAj4CFWOKOB3FYiipsSwE9mVF37tyF/D3ygHMsZdmPP7I1vs9KX5Xy3q6AI4TLz0KYW0puChUp5JLpG0a3u08D7XhSXJEFbbm0IsShN8TyvkcaO3o0Rm7HgbQu2Hqfj9Z9WKk7uRWbrlVQuaZm/jPGFAT8IgIpFtmbuIW3MHmlq/klJ16+NU/hm9NxoCDcFWh/oSaGxm9WwXAI5kgHGyYnCuA+Vd18cIK5ajKOpSIZdOgG5rI+ew2WK6olXfCTnCsinR+UvlvK/orq7OUC+/9kCgYEA8R3sPdhS+m7+KCrBUBDTrdmfF0L7HdO8DDmaZe8rEvSLb0Bq8OSnHVimxnVHVtjNU7xoPxW0OlPT+eOYe77SEYDHz59RbL7Fkb5H0xXfIdFoIbTf2IwD61kKgw3bqcna31/s3YqTo3kFKTcEwmnQ9PcERIvGsmh3ru+U1adkbPsCgYEAxSGuZ1DAZRuUPvdjLsjfeA3MvlHYafF6XePJTOSdUf+idoRH2IBDAKHW18/O20txqhQG8kljOy4vDnuLvwowiLok3F/MAEwCrjhr21mrck/pCqA3bmFgdLO/9EyZDf2xgdJMCC+8BWQRzR6C0ebTuUIlRIE5Lr04atYQFaO6LP8CgYByflL/ywkcAjiNuj+xVUwu8XeqBBRaRYC2DWRTow5BIf5UBbLCUNFKDh6jfm0xwCE/8edOjW/XgpbVwk1V9Xaq+Qvoey6fBLesTT6t7WTXGijoWIsyuMnjp5RmRt5X8ZINH+/KA1O3/G+G8qk/6B9hMyrDodvoO9MZLoruKV52oQKBgBTj4dh+/TR5vLcDflY54TyWscjFYZqwhVgnyHBGlclXvr6ye+6cgP0zKVJLak9g6lWss6O/VS2zUjdFrmR7TvNeToOv/y1U4L/XqM5g7UM65qZCnj0rQo57ce8QovORm9r3Dyma7WDg3uYOwqw9utgaA1sEGqwyTyU7NA8m/5a/AoGBAI68aldO1R8zWoyVnM8zbk6uOtkXcw1aF/IG0+K1wP/ghqgInGMMYbVMJiC9ZDJJ1x3MRaTMX6sHIlBaVoi2TQmgHC+vBiI8LnLnHuxDynX5Y5dzJDNEl+5k8yHYXvklDoA5BVL8dnzD5pS2J6Bxi1jZiMgRBw+IFBwFW1Z/DlHM";
    //彩票名字存储键值
    public static final String TXT_NAME = "lottory_name";
    //彩票图片存储键值
    public static final String IMAGE_NAME = "lottory_image";
    public static final String TXT_ID = "lottory_id";
    //彩种存储名字
    public static final String MENU_LIST = "menu_list";
    public static final String TXT_ISSTOP = "lottory_stop";
    public static final String ISPLUS_AWARD = "lottory_award";
    public static final String TXT_INTRO = "lottory_intro";
    //API
    public static final String PHONE_REGIST = "/user/regist";
    public static final String USER_LOGIN = "/user/login";
    public static final String FORGOT_PWD = "/user/forgotpwd";
    public static final String SET_PWD = "/user/setpwd";
    public static final String RESET_PWD = "/user/resetpwd";
    public static final String BIND_PHONE="/user/bindphone";
    public static final String CHANGE_PHONE = "/user/changephone";
    public static final String BIND_WX = "/user/bindweixin";
    public static final String UNBIND_WX = "/user/unbindweixin";
    public static final String BIND_QQ = "/user/bindqq";
    public static final String UNBIND_QQ = "/user/unbindqq";
    public static final String SET_ICON = "/user/seticon";
    public static final String SET_NIKENAME = "/user/setnickname";
    public static final String SET_SEX = "/user/setsex";
    public static final String SET_PAYPWD = "/user/setpaypwd";
    public static final String RESET_PAYPWD = "/user/resetpaypwd";
    public static final String OPEN_PAYPWD = "/user/openpaypwd";
    public static final String FORGOT_PAYPWD = "/user/forgotpaypwd";
    public static final String VERIFY_PAYPWD = "/user/verifypaypwd";
    public static final String AUTH_REALNAME = "/user/authrealname";
    public static final String CDK_REEDM = "/user/cdkey_redeem";
    public static final String INVITE = "/user/invite";
    public static final String INVITE_INFO = "/user/invite_info";
    public static final String DAILY_CHECK = "/user/dailycheck";
    public static final String CREDITS_TASKINFO = "/user/credits/taskinfo";
    public static final String OPEN_DRAW = "/user/phoneregistgift_draw";
    public static final String RECEIVE_GIFT = "/user/receive_gift";
    public static final String CREDITS_HISTORY = "/user/credits_history";
    public static final String USER_INFO = "/user/info";
    public static final String FUNDINFO = "/user/fundinfo";
    public static final String FUNDHISTORY = "/user/fundhistory";
    public static final String WITHDRAW_INFO = "/user/withdraw_info";
    public static final String WITHDRAW_PROGRESS = "/user/withdraw_progress";
    public static final String WITHDRAW = "/user/withdraw";
    public static final String BANCARD = "/user/bankcard";
    public static final String ADD_BANKCARD = "/user/addbankcard";
    public static final String DELETE_BANKCARD = "/user/deletebankcard";
    public static final String TICKETINFO = "/user/ticketinfo";
    public static final String BUYCAI_TICKETS = "/user/buycaitickets";
    public static final String OPENCAI = "/opencai/latest";
    public static final String OPNENCAI_HISTORY = "/opencai/history";
    public static final String OPENCAI_DIGHISTORY = "/opencai/dighistory";
    public static final String ORDER_COMMIT = "/buycai/order_commit";
    public static final String BUYCAI_INFO = "/buycai/info";
    public static final String BUYCAI_GAME = "/buycai_game";
    public static final String BUYCAI_HISTORY_UO = "/buycai/history_uo";
    public static final String BUYCAI_HISTORY_VO = "/buycai/history_vo";
    public static final String BUYCAI_UO_DETAIL = "/buycai/uo_detail";
    public static final String BUYCAI_VO_DETAIL = "/buycai/vo_detail";
    public static final String BUYCAI_STOPCHASE = "/buycai/stopchase";
    public static final String IS_DEBUG = "/recharge/isdebug";
    public static final String RECHARGE_WX = "/recharge/wechat";
    public static final String RECHARGE_ALI = "/recharge/alipay";
    public static final String APP_UPLOAD = "/assets/appupload";
    public static final String NEWS_LIST = "/options/discover_news_list";
    public static final String DISCOVER_BANNER = "/options/discover_banner";
    public static final String CONTACT_INFO = "/options/contact_info";
    public static final String FAQ_LIST = "/options/faq_list";
    public static final String USER_SERVICE = "/options/agreement";
    public static final String CREDITS_MALL = "/user/credits_mall";
    public static final String EXCHANGE_GOODS = "/user/exchange_goods";
    public static final String EXCHANGE_GOODS_HISTORY = "/user/exchange_goods_history";
    public static final String ACTIVITY_LIST = "/activity/list";
    public static final String ACTIVITY_DETAIL = "/activity/detail";
    public static final String GETTER_LIST = "/activity/detail_getterlist";
    public static final String HOME_INDEX = "/options/home_index";
    public static final String SENDCODE = "/user/sendcode";

        public static class ShowMsgActivity {
        public static final String STitle = "showmsg_title";
        public static final String SMessage = "showmsg_message";
        public static final String BAThumbData = "showmsg_thumb_data";
    }

}
