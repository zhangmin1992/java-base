package com.my.java.base.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class testFile {
    public static void main(String[] args) {
        String str = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("in.txt"))));
            while ((str = br.readLine()) != null) {
                str = str.trim();
                String[] txtContent = str.split(",");
                String contractId = String.valueOf(txtContent[0]);
                if(contractId.equals("99")) {
                    System.out.println("findContractById 合同不存在 contractId=" + contractId);
                    break;
                }
                System.out.println("读入数据" + str +"行");
            }
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
