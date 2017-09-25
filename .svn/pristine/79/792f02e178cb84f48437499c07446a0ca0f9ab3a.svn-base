package com.ruijie.spl.billingEngine.common.helper;

import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Created by Administrator on 2017/8/31.
 */
@Component
public class DrlFileProcessorHelper {
    private final int buf_size = 1024;

//    public byte[] drlFileToBytes(String fileFullName) throws FileNotFoundException {
//        File file = new File(fileFullName);
//        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream((int) file.length());
//
//        byte[] buffer = new byte[1024];
//        int len = 0;
//
//        try {
//            while ((len = inputStream.read(buffer, 0, buf_size)) != -1) {
//                outputStream.write(buffer, 0, len);
//            }
//            return outputStream.toByteArray();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    public String drlFileToString(String drlFileFullName) throws FileNotFoundException {

        StringBuilder builder = new StringBuilder();

        BufferedReader reader = new BufferedReader(new FileReader(drlFileFullName));
        String lineContent;
        try {
            while ((lineContent = reader.readLine()) != null) {
                builder.append(lineContent);
                builder.append("\r\n");
            }
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
