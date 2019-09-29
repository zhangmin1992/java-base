package com.my.java.util.exportjar;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  组件测试
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Sep 29, 2019 2:14:25 PM
 */
public class Test {

	public static void main(String[] args) throws Exception {
		RecordDO u1 = new RecordDO(1, new Date(),"liyebing@163.com");
		RecordDO u2 = new RecordDO(2, new Date(), "kongxuan@163.com");

	    List<RecordDO> userList = new ArrayList<RecordDO>();
	    userList.add(u1);
	    userList.add(u2);

	    File file = ExportDataToExcel.<RecordDO> export(userList, "test9.xls","sheet名");
	}

}
