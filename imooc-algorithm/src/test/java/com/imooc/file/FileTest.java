package com.imooc.file;

import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.Scanner;

/**
 * @ClassName FileTest
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/26 15:47
 * @Version 1.0
 */
public class FileTest {
    public static void main(String args[]) throws IOException {
//        char c;
//        // 使用 System.in 创建 BufferedReader
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
////        br.read();
////        br.readLine();
//
//        System.out.println("输入字符, 按下 'q' 键退出。");
//        // 读取字符
//        do {
//            c = (char) br.read();
//            System.out.println(c);
//        } while (c != 'q');

//        DataOutputStream out = new DataOutputStream(new FileOutputStream("text2.txt"));
//
//        out.writeChars("tezt");
//        out.close();


//        DataInputStream in = new DataInputStream(new FileInputStream("text2.txt"));
//        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
//        String s = bf.readLine();
//
//        System.out.println(s);
//        in.close();
        String encoding = "UTF-8";
        File file = new File("text2.txt");
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        FileInputStream in = null;

        in = new FileInputStream(file);
        in.read(filecontent);
        String a =  new String(filecontent, encoding);
        String[] test = StringUtils.splitString(a, "\n");

        System.out.println(test[0]);
        System.out.println(test.length);
        for (String t:test) {
            System.out.println(t);
        }

        System.out.println(a);

        in.close();


    }
}
