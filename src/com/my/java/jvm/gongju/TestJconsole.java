package com.my.java.jvm.gongju;

import java.io.IOException;

/**
 * 
 * 对于jstack日志，我们要着重关注如下关键信息
 * Deadlock：表示有死锁 Waiting on
 * condition：等待某个资源或条件发生来唤醒自己。具体需要结合jstacktrace来分析，比如线程正在sleep，网络读写繁忙而等待
 * Blocked：阻塞 Waiting on monitor entry：在等待获取锁
 * 如果说系统慢，那么要特别关注Blocked,Waiting on condition
 * 如果说系统的cpu耗的高，那么肯定是线程执行有死循环，那么此时要关注下Runable状态。
 * 
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangmin
 * @date Feb 22, 2019 5:21:58 PM
 */
public class TestJconsole {

	public static void main(String[] args) throws IOException {
		/**
		 * 等待阻塞输入
		 */
//		System.out.println("1");
//		System.in.read();

		while (true) {
			System.out.println("死循环啦！！");
		}
	}

}
