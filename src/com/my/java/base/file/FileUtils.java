/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.my.java.base.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Description: 资源文件上传工具类
 * @ClassName: FileUtils
 */
public class FileUtils {

    /**
     * 添加文件
     *
     * @param filename: 文件地址 + 文件名称
     * @param data:     数据
     * @return: void
     **/
    public static void saveFile(String filename, byte[] data) throws Exception {
        if (data != null) {
            File file = new File(filename);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
            }
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data, 0, data.length);
            fos.flush();
            fos.close();
        }
    }


    /**
     * 读取文件内容
     *
     * @param filename: 文件地址 + 文件名称
     * @return: java.lang.String
     **/
    public static String getKey(String filename) {
        StringBuffer sbf = new StringBuffer();
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String str;
            while ((str = in.readLine()) != null) {
                sbf.append(str);
            }
        } catch (IOException e) {
        }
        return sbf.toString();
    }

}
