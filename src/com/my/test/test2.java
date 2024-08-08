package com.my.test;

import com.meituan.mobile.movie.common.money.Money;

import java.math.RoundingMode;
import java.text.ParseException;
import java.util.*;

public class test2 {

	public static void main(String[] args) throws ParseException {

	    String str2 = "段丽娜;AAA_jzwangdf;安郭健;曾晔;常楼娟;陈安和;程俊华;成亮;程硕博;程晓宇;陈俊生;丁明一;杜艳红;范传奇;冯美星;高昌勇;谷晓艳;韩少云;韩耀飞;郝云霄;侯亚强;黄书林;黄亚军;黄烨;胡杰;胡新亮;胡悦;李大帅;李佳宇;李继英;李俊鑫;李磊;李瑞欣;刘闯;刘国斌;刘雷;刘丽丽;刘立伟;刘梦瑶;刘帅辰;刘寺齐;刘新;李薇;李文华;李欣;李幸泽;李源;李宇龙;马斌;马红星;马晓锋;马兴男;马志国;苗军富;闵卫;牛犇;庞丽静;朴乾;乔美娜;齐雷;祁天暄;申童童;时东雪;石蕾;宋家杰;王丹波;王丹凤;王凯;王克晶;王婷婷;王伟超;王晓婧;王亚峰;王宇;万巨擎;魏明择;卫思敏;魏小芳;魏祎元;温照荣;吴华;吴慧青;吴水粮;肖庆雨;肖旭伟;席云;许海越;杨帆;杨燕;杨洋;杨翊华;杨雨申;闫鹏宇;殷晓倩;尹玉婷;游成伟;于健;张超;张超;张春阳;张海华;张竞也;张久军;张继文;张敏;张鹏;张玮琦;张晓燕;张欣宇;张岩;张玉;张月;张志刚;赵成明;赵芳;赵乐义;赵瑞杰;赵微;郑学晶;周华飞";
        String str1 = "段丽娜;曾晔;常楼娟;陈安和;程俊华;成亮;程硕博;程晓宇;陈俊生;丁明一;杜艳红;范传奇;樊旭;冯美星;高昌勇;郭子健;谷晓艳;韩少云;韩耀飞;郝云霄;侯亚强;侯泳;黄书林;黄亚军;黄烨;胡杰;胡新亮;胡悦;姜祥云;吉祥;李春喜;李大帅;李佳宇;李继英;李俊鑫;李瑞欣;刘闯;刘恒;刘雷;刘丽丽;刘立伟;刘梦瑶;刘帅辰;刘寺齐;刘新;刘志超;李薇;李文华;李小露;李欣;李源;李宇龙;路国雨;马斌;马红星;马晓锋;马志国;闵卫;牛犇;庞丽静;朴乾;乔美娜;齐雷;祁天暄;申童童;时东雪;石蕾;史利鹏;宋家杰;王丹波;王丹凤;王凯;王克晶;王婷婷;王伟超;王晓婧;王亚峰;王宇;万巨擎;卫思敏;魏小芳;魏祎元;翁小虎;温照荣;吴富磊;吴华;吴慧青;吴水粮;肖庆雨;肖旭伟;席云;许海越;杨帆;杨吉钰;杨燕;杨洋;杨翊华;杨雨申;晏弘洲;闫鹏宇;闫彦秀;闫子千;尹玉婷;游成伟;于健;张斌;张超;张超;张春阳;张海华;张竞也;张继文;张敏;张鹏;张硕;张玮琦;张晓燕;张欣宇;张岩;张毅泽;张玉;张月;张志刚;赵成明;赵芳;赵琪;赵瑞杰;赵微;郑航宇;郑学晶;周华飞;周思雨;朱冰";


        //		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date = sdf.parse("2019-06-27 23:59:59");
//		System.out.println(getAccountCloseDate());
//		Date date2 = getLastMonthDate();
//		System.out.println(date2);
//		if(date.before(getAccountCloseDate()) && date.after(date2)) {
//			System.out.println("oooo");
//		}
//		String aString="2019-02-09";
//		System.out.println(aString.split("-")[0]);
//		System.out.println(aString.split("-")[1]);
//		System.out.println(aString.split("-")[2]);

//        List<Integer> leftPrices = new ArrayList<>();
//        leftPrices.add(30400-166);
//        leftPrices.add(30400-167);
//        leftPrices.add(30400-167);
//        Integer needPayMoney = 90700;
//        for (int i = 0; i < leftPrices.size(); i++) {
//            System.out.println(getCardSaveMoneyPerGoods(i,leftPrices,needPayMoney,needPayMoney,needPayMoney));
//        }

        testt(str1,str2);

   }

	public static Date getAccountCloseDate() {
		Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(new Date());
        tempStart.set(Calendar.DAY_OF_MONTH, 26);
        tempStart.set(Calendar.HOUR_OF_DAY, 23);
        tempStart.set(Calendar.MINUTE, 59);
        tempStart.set(Calendar.SECOND, 59);
        return tempStart.getTime();
	}

	public static Date getLastMonthDate() {
		Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(new Date());
        tempStart.set(Calendar.DAY_OF_MONTH, 1);
        tempStart.add(Calendar.MONTH, -1);
        tempStart.set(Calendar.HOUR_OF_DAY, 0);
        tempStart.set(Calendar.MINUTE, 0);
        tempStart.set(Calendar.SECOND, 0);
        return tempStart.getTime();
	}

    private static int getCardSaveMoneyPerGoods(int index, List<Integer> leftPrices, int totalLeftPrice, int leftSaveMoney, int saveMoney) {
        int saveMoneyPerGoods = 0;
        // 如果不是最后一个商品，按比例计算
        if (index != leftPrices.size() - 1) {
            //单个商品剩余待支付金额 除以 总的商品剩余金额  乘以 券面值
            saveMoneyPerGoods = (int) (Money.toYuan(leftPrices.get(index)).divide(Money.toYuan(totalLeftPrice), 6, RoundingMode.HALF_UP).multi(Money.toYuan(saveMoney)).toFen());
            if (leftSaveMoney < saveMoneyPerGoods) {
                saveMoneyPerGoods = leftSaveMoney;
            }
        }
        // 如果已经是最后一个商品，直接使用全部剩余金额
        else {
            saveMoneyPerGoods = leftSaveMoney;
        }
        return saveMoneyPerGoods;
    }

    public static void testt(String str,String str2) {
	    String[] strArray = str.split(";");
	    for (String temp : strArray) {
	        if (!str2.contains(temp)) {
	            System.out.println(temp);
            }
        }

    }

}
