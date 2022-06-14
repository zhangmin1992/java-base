package com.my.test;

import com.meituan.mobile.movie.common.money.Money;

import java.math.RoundingMode;
import java.text.ParseException;
import java.util.*;

public class test2 {

	public static void main(String[] args) throws ParseException {
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

        List<Integer> leftPrices = new ArrayList<>();
        leftPrices.add(30400-166);
        leftPrices.add(30400-167);
        leftPrices.add(30400-167);
        Integer needPayMoney = 90700;
        for (int i = 0; i < leftPrices.size(); i++) {
            System.out.println(getCardSaveMoneyPerGoods(i,leftPrices,needPayMoney,needPayMoney,needPayMoney));
        }

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

}
