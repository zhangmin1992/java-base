package com.my.java.base.bijiao3;

/**
 * Created by chensitong on 2018/10/15.
 */
public class JumpUrlConstants {

    /** 美团App跳转链接 */

    //美团Ios电影频道首页
    public static final String MEITUAN_IOS_MOVIE_HOME_URL = "imeituan://www.meituan.com/deal/movieshow";
    //美团电影热映列表
    public static final String MEITUAN_IOS_HOT_MOVIE_HOME_URL = "imeituan://www.meituan.com/mrn?mrn_biz=movie&mrn_entry=moviechannel-movielist&mrn_component=moviechannel-movielist&tab=0";
    //美团Ios影院排片页
    public static final String MEITUAN_IOS_CINEMA_URL = "imeituan://www.meituan.com/merchantDispatch?channel=cinema&cinemaDeals=1&poiID=%s";
    //美团上映影片与影院页
    public static final String MEITUAN_MOVIE_CINEMA_LIST_URL = "imeituan://www.meituan.com/movie/cinemalist?movie_id=%s";
    //美团App Android上映影片与影院页
    public static final String MEITUAN_ANDROID_MOVIE_CINEMA_LIST_URL = "imeituan://www.meituan.com/movie/cinemalist?movieId=%s";
    //美团Android首页
    public static final String MEITUAN_ANDROID_MOVIE_HOME_URL = "imeituan://www.meituan.com/movie/mainpage";
    //美团Android影院排片页
    public static final String MEITUAN_ANDROID_CINEMA_URL = "imeituan://www.meituan.com/movie/poicinema?cinemaId=%s";
    //美团deal详情页
    public static final String MEITUAN_DEAL_DETAIL_URL = "imeituan://www.meituan.com/deal/confirm_order?cinemaId=%s&dealId=%s&dealid=%s";
    //美团点播播放页
    public static final String MEITUAN_VOD_DETAIL_URL = "imeituan://www.meituan.com/movie/onlinevideo?movieId=%s";
    //影院排片页，ios/android通用
    public static final String MEITUAN_POI_URL = "imeituan://www.meituan.com/merchant?id=%s&channel=cinema&cinemaDeals=1";
    // 演出项目详情页
    public static final String MEITUAN_SHOW_PERFORMANCE_URL = "https://h5.51ping.com/app/myshow/index.html?utm_source=gpmtx#/detail/%s";
    // 演出首页
    public static final String MEITUAN_SHOW_INDEX_URL = "https://h5.51ping.com/app/myshow/index.html?utm_source=gpmt";
    //衍生品首页
    public static final String MEITUAN_DERIVATIVE_HOME_URL = "imeituan://www.meituan.com/web?url=https%3A%2F%2Fm.maoyan.com%2Fstore";
    public static final String MEITUAN_DERIVATIVE_USE_URL = "imeituan://www.meituan.com/web?url=https%3A%2F%2Fstore.maoyan.com%2Fmmall%2Fstore%2Fdetail%2F%s";
    //美团电影频道首页
    public static final String MEITUAN_HOMEPAGE = "imeituan://www.meituan.com/movie/homepage?utm_source=group_coupon";
    //美图卖品订单
    public static final String MEITUAN_DEAL_ORDER_URL = "imeituan://www.meituan.com/mrn?mrn_biz=movie&mrn_entry=moviechannel-dealorderdetail&mrn_component=moviechannel-dealorderdetail&orderid=%s&useCache=NO";
    public static final String MEITUAN_SHOW_ORDER_URL = "https://h5.dianping.com/app/myshow/#/order-detail?id=%s";
    public static final String MEITUAN_SEAT_ORDER_URL = "imeituan://www.meituan.com/order?channel=movie&oid=%s&stid=&useCache=NO";
    /** 美团App跳转链接 end */

    /** 美团小程序跳转链接 appid||实际跳转链接*/
    //美团小程序首页跳转url
    public static final String MINIAPPURL = "wxde8ac0a21135c07d||movie/pages/home/index";
    //美团小程序排片页
    public static final String MINIAPP_CINEMA_URL = "wxde8ac0a21135c07d||movie/pages/cinema/cinema?cinemaId=%s";
    //美团小程序上映影片与影院页
    public static final String MINIAPP_MOVIE_CINEMA_LIST_URL = "wxde8ac0a21135c07d||movie/pages/cinema/movie?movieId=%s";

    /** 美团小程序跳转链接 end */

    /** 猫眼App跳转链接 */

    public static final String MAOYAN_HOME_URL = "meituanmovie://www.meituan.com/filmlist";
    //猫眼APP热映列表
    public static final String MAOYAN_HOT_HOME_URL = "maoyan://maoyan.com/filmlist?index=onshow";

    public static final String MAOYAN_PRE_ORDER_URL = "meituanmovie://www.meituan.com/deal/confirm_order?cinemaId=%s&dealId=%s";

    public static final String MAOYAN_DEAL_DETAIL_URL = "meituanmovie://www.meituan.com/movie/deal/detail?dealId=%s&dealid=%s";

    public static final String MAOYAN_CINEMA_URL = "meituanmovie://www.meituan.com/cinema?id=%s";

    public static final String MAOYAN_CINEMA_MOVIE_URL = "meituanmovie://www.meituan.com/cinema?id=%s&movieId=%s";

    public static final String MAOYAN_MOVIE_CINEMA_LIST_URL = "meituanmovie://www.meituan.com/movie_schedule?id=%s";

    public static final String MAOYAN_VOD_DETAIL_URL = "maoyan://maoyan.com/onlinevideo?movieId=%s";
    // 演出项目详情页
    public static final String MAOYAN_SHOW_PERFORMANCE_URL = "https://h5.51ping.com/app/myshow/index.html?utm_source=gpmyx#/detail/%s";
    // 演出首页
    public static final String MAOYAN_SHOW_INDEX_URL = "https://h5.51ping.com/app/myshow/index.html?utm_source=gpmy";
    // 衍生品商城首页
    public static final String MAOYAN_MALL_DERIVATIVE_URL = "meituanmovie://www.meituan.com/web?url=https%3A%2F%2Fm.maoyan.com%2Fstore";
    public static final String MAOYAN_MALL_DERIVATIVE_USE_URL = "maoyan%3A%2F%2Fmaoyan.com%2Fweb?url=https%3A%2F%2Fstore.maoyan.com%2Fmmall%2Fstore%2Fdetail%2F%s";
    //猫眼卖品订单链接
    public static final String MAOYAN_DEAL_ORDER_URL = "meituanmovie://www.meituan.com/mrn?mrn_biz=movie&mrn_entry=moviechannel-dealorderdetail&mrn_component=moviechannel-dealorderdetail&orderid=%s";
    public static final String MAOYAN_SHOW_ORDER_URL = "https://h5.dianping.com/app/myshow/#/order-detail?id=%s";
    public static final String MAOYAN_SEAT_ORDER_URL = "maoyan://maoyan.com/mine/orderlist/seatorder?from=1&oid=%s&uid=%s";
    /** 猫眼App跳转链接 end */


    /** 猫眼微信小程序跳转链接 */
    //首页
    public static final String WECHAT_HOME_URL = "/pages/cinema/index";
    //deal详情页跳转链接
    public static final String WECHAT_DEAL_DETAIL_URL = "/pages/goods/buy?dealId=%s&cinemaId=%s";
    //点播播放页跳转链接
    public static final String WECHAT_VOD_DETAIL_URL = "/pages/vod/detail/index?movieId=%s";
    //排片页跳转链接
    public static final String WECHAT_CINEMA_URL = "/pages/cinema/cinema?cinemaId=%s";
    // 跳转到指定影院
    public static final String WECHAT_CINEMA_MOVIE_URL = "/pages/cinema/cinema?cinemaId=%s&movieId=%s";
    //影片上映页
    public static final String WECHAT_MOVIE_CINEMA_LIST_URL = "/pages/cinemasub/movie?movieId=%s&hallType=%s";
    // 猫眼微信小程序演出项目详情页
    public static final String WECHAT_SHOW_PERFORMANCE_URL = "/pages/show/detail/index?id=%s&utm_source=gpwxx" ;
    // 猫眼微信小程序演出订单详情页
    public static final String WECHAT_SHOW_PERFORMANCE_ORDER_URL = "/pages/showsubs/order/detail?id=%s" ;
    // 猫眼微信小程序演出首页
    public static final String WECHAT_SHOW_INDEX_URL = "/pages/show/index/index?utm_source=gpwx";
    //衍生品商城
    public static final String WECHAT_MALL_URL = "/pages/mall/index";
    public static final String WECHAT_MALL_USE_URL = "/pages/webview/webview?url=https%3A%2F%2Fstore.maoyan.com%2Fmmall%2Fstore%2Fdetail%2F%s";
    //衍生品订单详情
    public static final String WECHAT_MALL_ORDER_DETAIL_URL = "https://store.maoyan.com/mmall/store/detail/%s";
    //deal详情页卖品查看订单跳转链接
    public static final String WECHAT_DEAL_ORDER_URL = "/pages/goods/order-detail?disOrderId=%s";
    public static final String WECHAT_MALL_DERIVATIVE_ORDER_URL = "/pages/mall/order-detail?orderId=%s";
    public static final String WECHAT_SEAT_ORDER_URL = "/pages/order/order?orderId=%s&userId=%s";
    /** 猫眼微信小程序跳转链接 end */


    /** 猫眼百度小程序跳转链接 */
    //首页
    public static final String BAIDU_HOME_URL = "/pages/cinema/index";
    //deal详情页跳转链接
    public static final String BAIDU_DEAL_DETAIL_URL = "/pages/goods/buy?dealId=%s&cinemaId=%s";
    //点播播放页跳转链接
    public static final String BAIDU_VOD_DETAIL_URL = "/pages/vod/detail/index?movieId=%s";
    //排片页跳转链接
    public static final String BAIDU_CINEMA_URL = "/pages/cinema/cinema?cinemaId=%s";
    //影片上映页
    public static final String BAIDU_MOVIE_CINEMA_LIST_URL = "/pages/cinema/movie?movieId=%s";
    //百度小程序的选座订单链接
    public static final String BAIDU_SEAT_ORDER_URL = "pages/order/order?orderId=%s";
    public static final String BAIDU_SHOW_ORDER_URL = "pages/show/order/index?id=%s";
    /** 猫眼百度小程序跳转链接 end */

    //首页
    public static final String JRTT_HOME_URL = "/pages/cinema/index";
    //deal详情页跳转链接
    public static final String JRTT_DEAL_DETAIL_URL = "/pages/goods/buy?dealId=%s&cinemaId=%s";
    //点播播放页跳转链接
    public static final String JRTT_VOD_DETAIL_URL = "/pages/vod/detail/index?movieId=%s";
    //排片页跳转链接
    public static final String JRTT_CINEMA_URL = "/pages/cinema/cinema?cinemaId=%s";
    //影片上映页
    public static final String JRTT_MOVIE_CINEMA_LIST_URL = "/pages/cinema/movie?movieId=%s&hallType=%s";
    //今日头条订单详情
    public static final String JRTT_SEAT_ORDER_URL = "pages/order/order?orderId=${order.id}=%s";
    public static final String JRTT_SHOW_ORDER_URL = "/pages/cinema/movie?movieId=%s&hallType=%s";
    /** 猫眼今日头条小程序跳转链接 end */

    /** 点评跳转链接 */
    //点评电影首页   如果不限制影院和影片
    public static final String DIAN_PING_MOVIE_HOME_URL = "dianping://moviemain";
    //点评热映列表
    public static final String DIAN_PING_HOT_MOVIE_HOME_URL = "dianping://www.meituan.com/mrn?mrn_biz=movie&mrn_entry=moviechannel-movielist&mrn_component=moviechannel-movielist&tab=0";
    // ios 影院排片页
    public static final String DIAN_PING_IOS_CINEMA_URL = "dianping://cinema?cinemaid=%s&inner=1";
    //ios 影片详情页
    public static final String DIAN_PING_IOS_MOVIE_DETAIL_URL = "dianping://moviedetail?movieId=%s&inner=1";
    //ios 影院排片页 + 指定movie
    public static final String DIAN_PING_IOS_CINEMA_MOVIE_URL = "dianping://cinema?cinemaid=%s&movieId=%s&inner=1";
    //安卓 影院排片页
    public static final String DIAN_PING_ANDRIOD_CINEMA_URL =  "dianping://moviepoicinema?cinemaId=%s";
    //安卓 影片详情页
    public static final String DIAN_PING_ANDRIOD_MOVIE_DETAIL_URL = "dianping://moviedetail?id=%s&inner=1";
    //安卓 影院排片页 + 指定movie
    public static final String DIAN_PING_ANDRIOD_CINEMA_MOVIE_URL = "dianping://moviepoicinema?cinemaId=%s&movieId=%s&inner=1";
    //点评安卓上映影片与影院页
    public static final String DIAN_PING_ANDROID_MOVIE_CINEMA_LIST_URL = "dianping://cinemalist?movieId=%s&inner=1";
    //点评 IOS 上映影片与影院页
    public static final String DIAN_PING_IOS_MOVIE_CINEMA_LIST_URL = "dianping://cinemalist?inner=1&movieid=%s&ishiddenheaderview=true&inner=1";
    //点评选座订单详情
    public static final String DIAN_PING_SEAT_ORDER_URL = "dianping://movieticketdetail?orderid=%s&userId=%s";
    //点评卖品订单详情
    public static final String DIAN_PING_DEAL_ORDER_URL = "dianping://mrn?mrn_biz=movie&mrn_entry=moviechannel-dealorderdetail&mrn_component=moviechannel-dealorderdetail&orderid=%s";
    //点评演出订单详情
    public static final String DIAN_PING_SHOW_ORDER_URL = "https://h5.dianping.com/app/myshow/#/order-detail?id=%s";
    /** 点评跳转链接 */

    // 演出项目详情页
    public static final String DIAN_PING_SHOW_PERFORMANCE_URL = "https://h5.51ping.com/app/myshow/index.html?utm_source=gpdpx#/detail/%s";
    // 演出首页
    public static final String DIAN_PING_SHOW_INDEX_URL = "https://h5.51ping.com/app/myshow/index.html?utm_source=gpdp";
    // 衍生品商城首页
    public static final String DIANPING_MALL_DERIVATIVE_URL = "dianping://web?url=https%3A%2F%2Fm.maoyan.com%2Fstore";
    public static final String DIANPING_MALL_DERIVATIVE_USE_URL = "dianping://web?url=https%3A%2F%2Fstore.maoyan.com%2Fmmall%2Fstore%2Fdetail%2FDEALID";
    /** 点评 app 跳转链接 end */

    // 演出项目详情页
    public static final String GEWARA_SHOW_PERFORMANCE_URL = "gewara://com.gewara.movie/drama?dramaid=%s";
    public static final String GEWARA_SEAT_ORDER_URL = "gewara://com.gewara.movie/movie_orderdetail?orderid=%s";
    public static final String GEWARA_SHOW_ORDER_URL = "https://h5.dianping.com/app/myshow/#/order-detail?id=%s";
    // 演出首页

    public static final String GEWARA_SHOW_INDEX_URL = "gewara://com.gewara.movie/dramatab";
    /** 格瓦拉 app 跳转链接 end */

    /** 猫眼i版跳转链接        微博小程序与i版一致， 但是首页地址为空*/
    public static final String MAOYAN_I_HOME_PROD_URL = "https://m.maoyan.com";
    public static final String MAOYAN_I_HOT_MOCVIE_URL = "https://i.maoyan.com/#movie";
    public static final String MAOYAN_I_HONE_ST_URL = "https://canary.movie.st.maoyan.com";

    public static final String MAOYAN_I_CINEMA_PROD_URL = "https://m.maoyan.com/mtrade/cinema/cinema?cinemaId=%s";
    public static final String MAOYAN_I_CINEMA_ST_URL = "https://canary.movie.st.maoyan.com/mtrade/cinema/cinema?cinemaId=%s";

    public static final String MAOYAN_I_MOVIE_PROD_URL = "https://m.maoyan.com/mtrade/cinema/movie?movieId=%s";
    public static final String MAOYAN_I_MOVIE_ST_URL = "https://canary.movie.st.maoyan.com/mtrade/cinema/movie?movieId=%s&hallType=%s";
    public static final String MAOYAN_I_SEAT_ORDER_URL = "https://m.maoyan.com/mtrade/order/detail?orderId=%s";
    public static final String MAOYAN_I_SHOW_ORDER_URL = "https://show.maoyan.com/qqw#/order-detail?id=%s";
    public static final String MAOYAN_I_DEAL_ORDER_URL = "https://m.maoyan.com/mtrade/deal/order/detail/%s";
    public static final String MAOYAN_I_DERIVATIVE_ORDER_URL = "https://store.maoyan.com/mmall/order/detail/%s";
    public static final String WEIBO_SEAT_ORDER_URL = "https://m.maoyan.com/mtrade/order/detail?orderId=%s";
    public static final String MAOYAN_I_SHOW_USE_URL = "https://show.maoyan.com/qqw#/detail/%s";
    public static final String MAOYAN_I_MALL_DERIVATIVE_USE_URL = "https://store.maoyan.com/mmall/store/detail/%s";
    public static final String MAOYAN_I_MEMBER_DERIVATIVE_USE_URL = "https://eagle.maoyan.com/membercard/detail?_v_=yes&version=4&fromShow=1&from=canary&cardId=%s";
    /** 猫眼i版跳转链接*/



    /*天目i版 test环境*/
    public static final String TIANMU_IBAN_HOME_TEST_URL = "http://canary.movie.test.maoyan.com/?merCode=1000318";
    /*天目i版 st环境*/
    public static final String TIANMU_IBAN_HOME_ST_URL = "https://canary.movie.st.maoyan.com/?merCode=1000318";
    /*天目i版 prod环境*/
    public static final String TIANMU_IBAN_HOME_PROD_URL = "https://m.maoyan.com/?merCode=1000318";
    public static final String TIANMU_SEAT_ORDER_URL = "https://co.maoyan.com/mtrade/order/detail?orderId=%s";

    //*** 如果只是指定了一个会员卡(大卡) 那么有4个渠道需要跳转到相应的url *** //  m.maoyan.com 是线上域名 canary.movie.st.com 是 st 域名
    public static final String WX_SMPRO_CARD_URL = "/pages/membercard/new-card?crystalCardId=%s&originType=0"; //微信小程序 会员卡单卡跳转链接

    public static final String MT_APP_CARD_URL = "imeituan://www.meituan.com/web/?url=https%3A%2F%2Fm.maoyan.com%2Fmultiplecard%2Fdetail%2FCRYSTALCARDID"; //美团APP 会员卡单卡跳转链接

    public static final String DP_APP_CARD_URL = "https://m.maoyan.com/multiplecard/detail/%s"; //点评APP 会员卡单卡跳转链接

    public static final String DP_APP_GOODS_URL = "dianping://movie_deal_confirm_order?cinemaId=%s&dealId=%s"; //点评APP 会员卡单卡跳转链接

    public static final String DP_APP_ONLINE_MOVIE_URL = "dianping://movieonlinevideo?movieId=%s"; //点评APP 会员卡单卡跳转链接

    public static final String MY_APP_CARD_URL = "meituanmovie://www.meituan.com/web?url=https%3A%2F%2Fm.maoyan.com%2Fmultiplecard%2Fdetail%2FCRYSTALCARDID"; //猫眼APP 会员卡单卡跳转链接

    public static final String MT_WX_CARD_URL = "/index/pages/h5/h5?f_token=1&f_openId=1&f_pos=1&f_ci=1&weburl=https%3A%2F%2Fm.maoyan.com%2Fmultiplecard%2Fdetail%2FCRYSTALCARDID";

    public static final String DEFAULT_CARD_URL = "https://m.maoyan.com/multiplecard/list";
}
