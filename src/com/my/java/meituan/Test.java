package com.my.java.meituan;

public class Test {

	public static void main(String[] args) {
//		Long orderId = Long.valueOf("21277423625");
//		Long remainder = orderId % 1024;
//		System.out.println(remainder);
		
		//order_fund_flow_0009
//		Long orderId = Long.valueOf("21277423625");
//		long remainder = orderId % 1024;
//	    String suffix = String.format("%04d", remainder);
//	    System.out.println(suffix);
		
		String tempString="[zhangmin46@set-tx-maoyan-match-staging03 maoyan-match]$ grep '获取支付时间段微信数据 range=' info.log\n" + 
				"[{}][2019-12-26 10:51:28.348][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 00:00:00 CST 2019Tue Dec 24 01:00:00 CST 2019 内的数据 条数=81\n" + 
				"[{}][2019-12-26 10:51:29.041][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 01:00:00 CST 2019Tue Dec 24 02:00:00 CST 2019 内的数据 条数=43\n" + 
				"[{}][2019-12-26 10:51:29.652][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 02:00:00 CST 2019Tue Dec 24 03:00:00 CST 2019 内的数据 条数=18\n" + 
				"[{}][2019-12-26 10:51:30.215][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 03:00:00 CST 2019Tue Dec 24 04:00:00 CST 2019 内的数据 条数=17\n" + 
				"[{}][2019-12-26 10:51:30.778][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 04:00:00 CST 2019Tue Dec 24 05:00:00 CST 2019 内的数据 条数=2\n" + 
				"[{}][2019-12-26 10:51:31.295][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 05:00:00 CST 2019Tue Dec 24 06:00:00 CST 2019 内的数据 条数=7\n" + 
				"[{}][2019-12-26 10:51:31.834][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 06:00:00 CST 2019Tue Dec 24 07:00:00 CST 2019 内的数据 条数=22\n" + 
				"[{}][2019-12-26 10:51:32.404][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 07:00:00 CST 2019Tue Dec 24 08:00:00 CST 2019 内的数据 条数=57\n" + 
				"[{}][2019-12-26 10:51:33.048][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 08:00:00 CST 2019Tue Dec 24 09:00:00 CST 2019 内的数据 条数=157\n" + 
				"[{}][2019-12-26 10:51:33.851][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 09:00:00 CST 2019Tue Dec 24 10:00:00 CST 2019 内的数据 条数=368\n" + 
				"[{}][2019-12-26 10:51:35.000][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 10:00:00 CST 2019Tue Dec 24 11:00:00 CST 2019 内的数据 条数=554\n" + 
				"[{}][2019-12-26 10:51:36.457][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 11:00:00 CST 2019Tue Dec 24 12:00:00 CST 2019 内的数据 条数=871\n" + 
				"[{}][2019-12-26 10:51:38.390][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 12:00:00 CST 2019Tue Dec 24 12:10:00 CST 2019 内的数据 条数=171\n" + 
				"[{}][2019-12-26 10:51:39.224][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 12:10:00 CST 2019Tue Dec 24 12:20:00 CST 2019 内的数据 条数=175\n" + 
				"[{}][2019-12-26 10:51:40.067][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 12:20:00 CST 2019Tue Dec 24 12:30:00 CST 2019 内的数据 条数=203\n" + 
				"[{}][2019-12-26 10:51:40.959][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 12:30:00 CST 2019Tue Dec 24 12:40:00 CST 2019 内的数据 条数=247\n" + 
				"[{}][2019-12-26 10:51:41.918][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 12:40:00 CST 2019Tue Dec 24 12:50:00 CST 2019 内的数据 条数=218\n" + 
				"[{}][2019-12-26 10:51:42.841][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 12:50:00 CST 2019Tue Dec 24 13:00:00 CST 2019 内的数据 条数=247\n" + 
				"[{}][2019-12-26 10:51:43.807][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 13:00:00 CST 2019Tue Dec 24 13:10:00 CST 2019 内的数据 条数=249\n" + 
				"[{}][2019-12-26 10:51:44.771][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 13:10:00 CST 2019Tue Dec 24 13:20:00 CST 2019 内的数据 条数=255\n" + 
				"[{}][2019-12-26 10:51:45.751][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 13:20:00 CST 2019Tue Dec 24 13:30:00 CST 2019 内的数据 条数=264\n" + 
				"[{}][2019-12-26 10:51:46.749][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 13:30:00 CST 2019Tue Dec 24 13:40:00 CST 2019 内的数据 条数=262\n" + 
				"[{}][2019-12-26 10:51:47.737][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 13:40:00 CST 2019Tue Dec 24 13:50:00 CST 2019 内的数据 条数=269\n" + 
				"[{}][2019-12-26 10:51:48.746][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 13:50:00 CST 2019Tue Dec 24 14:00:00 CST 2019 内的数据 条数=250\n" + 
				"[{}][2019-12-26 10:51:49.716][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 14:00:00 CST 2019Tue Dec 24 14:10:00 CST 2019 内的数据 条数=252\n" + 
				"[{}][2019-12-26 10:51:50.689][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 14:10:00 CST 2019Tue Dec 24 14:20:00 CST 2019 内的数据 条数=258\n" + 
				"[{}][2019-12-26 10:51:51.668][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 14:20:00 CST 2019Tue Dec 24 14:30:00 CST 2019 内的数据 条数=279\n" + 
				"[{}][2019-12-26 10:51:52.685][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 14:30:00 CST 2019Tue Dec 24 14:40:00 CST 2019 内的数据 条数=242\n" + 
				"[{}][2019-12-26 10:51:53.638][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 14:40:00 CST 2019Tue Dec 24 14:50:00 CST 2019 内的数据 条数=267\n" + 
				"[{}][2019-12-26 10:51:54.630][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 14:50:00 CST 2019Tue Dec 24 15:00:00 CST 2019 内的数据 条数=283\n" + 
				"[{}][2019-12-26 10:51:55.649][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 15:00:00 CST 2019Tue Dec 24 15:10:00 CST 2019 内的数据 条数=282\n" + 
				"[{}][2019-12-26 10:51:56.674][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 15:10:00 CST 2019Tue Dec 24 15:20:00 CST 2019 内的数据 条数=289\n" + 
				"[{}][2019-12-26 10:51:57.711][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 15:20:00 CST 2019Tue Dec 24 15:30:00 CST 2019 内的数据 条数=238\n" + 
				"[{}][2019-12-26 10:51:58.657][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 15:30:00 CST 2019Tue Dec 24 15:40:00 CST 2019 内的数据 条数=240\n" + 
				"[{}][2019-12-26 10:51:59.600][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 15:40:00 CST 2019Tue Dec 24 15:50:00 CST 2019 内的数据 条数=287\n" + 
				"[{}][2019-12-26 10:52:00.634][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 15:50:00 CST 2019Tue Dec 24 16:00:00 CST 2019 内的数据 条数=298\n" + 
				"[{}][2019-12-26 10:52:01.683][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 16:00:00 CST 2019Tue Dec 24 16:10:00 CST 2019 内的数据 条数=268\n" + 
				"[{}][2019-12-26 10:52:02.748][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 16:10:00 CST 2019Tue Dec 24 16:20:00 CST 2019 内的数据 条数=290\n" + 
				"[{}][2019-12-26 10:52:03.796][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 16:20:00 CST 2019Tue Dec 24 16:30:00 CST 2019 内的数据 条数=311\n" + 
				"[{}][2019-12-26 10:52:04.867][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 16:30:00 CST 2019Tue Dec 24 16:40:00 CST 2019 内的数据 条数=289\n" + 
				"[{}][2019-12-26 10:52:05.924][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 16:40:00 CST 2019Tue Dec 24 16:50:00 CST 2019 内的数据 条数=329\n" + 
				"[{}][2019-12-26 10:52:07.027][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 16:50:00 CST 2019Tue Dec 24 17:00:00 CST 2019 内的数据 条数=320\n" + 
				"[{}][2019-12-26 10:52:08.114][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 17:00:00 CST 2019Tue Dec 24 17:10:00 CST 2019 内的数据 条数=363\n" + 
				"[{}][2019-12-26 10:52:09.279][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 17:10:00 CST 2019Tue Dec 24 17:20:00 CST 2019 内的数据 条数=361\n" + 
				"[{}][2019-12-26 10:52:10.427][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 17:20:00 CST 2019Tue Dec 24 17:30:00 CST 2019 内的数据 条数=386\n" + 
				"[{}][2019-12-26 10:52:11.627][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 17:30:00 CST 2019Tue Dec 24 17:40:00 CST 2019 内的数据 条数=434\n" + 
				"[{}][2019-12-26 10:52:12.906][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 17:40:00 CST 2019Tue Dec 24 17:50:00 CST 2019 内的数据 条数=480\n" + 
				"[{}][2019-12-26 10:52:14.260][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 17:50:00 CST 2019Tue Dec 24 18:00:00 CST 2019 内的数据 条数=487\n" + 
				"[{}][2019-12-26 10:52:15.636][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 18:00:00 CST 2019Tue Dec 24 18:10:00 CST 2019 内的数据 条数=511\n" + 
				"[{}][2019-12-26 10:52:17.050][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 18:10:00 CST 2019Tue Dec 24 18:20:00 CST 2019 内的数据 条数=619\n" + 
				"[{}][2019-12-26 10:52:18.650][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 18:20:00 CST 2019Tue Dec 24 18:30:00 CST 2019 内的数据 条数=605\n" + 
				"[{}][2019-12-26 10:52:20.209][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 18:30:00 CST 2019Tue Dec 24 18:40:00 CST 2019 内的数据 条数=658\n" + 
				"[{}][2019-12-26 10:52:21.927][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 18:40:00 CST 2019Tue Dec 24 18:50:00 CST 2019 内的数据 条数=730\n" + 
				"[{}][2019-12-26 10:52:23.726][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 18:50:00 CST 2019Tue Dec 24 19:00:00 CST 2019 内的数据 条数=701\n" + 
				"[{}][2019-12-26 10:52:25.442][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 19:00:00 CST 2019Tue Dec 24 19:10:00 CST 2019 内的数据 条数=728\n" + 
				"[{}][2019-12-26 10:52:27.222][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 19:10:00 CST 2019Tue Dec 24 19:20:00 CST 2019 内的数据 条数=739\n" + 
				"[{}][2019-12-26 10:52:29.018][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 19:20:00 CST 2019Tue Dec 24 19:30:00 CST 2019 内的数据 条数=659\n" + 
				"[{}][2019-12-26 10:52:30.675][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 19:30:00 CST 2019Tue Dec 24 19:40:00 CST 2019 内的数据 条数=679\n" + 
				"[{}][2019-12-26 10:52:32.370][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 19:40:00 CST 2019Tue Dec 24 19:50:00 CST 2019 内的数据 条数=643\n" + 
				"[{}][2019-12-26 10:52:33.996][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 19:50:00 CST 2019Tue Dec 24 20:00:00 CST 2019 内的数据 条数=644\n" + 
				"[{}][2019-12-26 10:52:35.712][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 20:00:00 CST 2019Tue Dec 24 21:00:00 CST 2019 内的数据 条数=3163\n" + 
				"[{}][2019-12-26 10:52:41.606][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 21:00:00 CST 2019Tue Dec 24 22:00:00 CST 2019 内的数据 条数=2258\n" + 
				"[{}][2019-12-26 10:52:45.930][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 22:00:00 CST 2019Tue Dec 24 23:00:00 CST 2019 内的数据 条数=992\n" + 
				"[{}][2019-12-26 10:52:48.131][qtp724270652-46][INFO][com.maoyan.service.match.biz.core.loader.impl.WxCashierPayLoader][65]:获取支付时间段微信数据 range=Tue Dec 24 23:00:00 CST 2019Tue Dec 24 23:59:59 CST 2019 内的数据 条数=367";
		
	}

}
