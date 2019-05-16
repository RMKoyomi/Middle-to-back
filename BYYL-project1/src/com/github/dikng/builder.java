package com.github.dikng;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Builder {
    public static void Build() {
        /**
         * 提供一个随机测试数据发生器，生成
         * 若干随机的正确表达式和不正确表达式（通过命令行参数决定是生成正确的还是
         * 不正确的以及生成的数量）。
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("是否随机生成正确表达式？(y/n)");
        String select = sc.nextLine();
        System.out.println("输入生成数量： ");
        int count = sc.nextInt();
        /*
        匹配正确的中缀表达式
         */
        String regex = "((\\(|-|\\+|/|\\*)-?(\\d+|\\[0-9]*(\\.?)[0-9]*);+)|(^-[0-9]+|^-[0-9]*(\\.?)[0-9]*)";
        Pattern pattern = Pattern.compile(regex);
        /*
        生成随机表达式
         */
        Random random = new Random();
        int length = random.nextInt(100);
        String ch = "+-/*()1234567890.;";    //表达式元素
        StringBuffer sb = new StringBuffer();
        String[] str = new String[count];
        switch (select) {
            case "n":
                for (int i = 0; i < count; i++) {
                    for (int j = 0; j < length; j++) {
                        int number = random.nextInt(17);
                        sb.append(ch.charAt(number));
                    }
                    Matcher matcher = pattern.matcher(sb.toString());
                    //表达式是否与正则表达式相匹配
                    boolean rs = matcher.matches();
                    if(!rs){
                        str[i] = sb.toString();
                        writeFile(str[i]);
                    }
                    else i--;
                }
                break;
            case "y":
                for (int i = 0; i < count; i++) {
                    for (int j = 0; j < length; j++) {
                        int number = random.nextInt(17);
                        sb.append(ch.charAt(number));
                    }
                    Matcher matcher = pattern.matcher(sb.toString());
                    //表达式是否与正则表达式相匹配
                    boolean rs = matcher.matches();
                    if(rs) {
                        str[i] = sb.toString();
                        writeFile(str[i]);
                    }
                    else i--;
                }
                break;
        }
    }
    public static void writeFile(String str) {
        /**
         * 将随机测试数据加入文件
         */
        try {
            File write = new File("C:\\Users\\pc\\BYYL-project1\\RandomOutput.txt");
            write.createNewFile();
            try (FileWriter writer = new FileWriter(write);
                 BufferedWriter out = new BufferedWriter(writer);
                    ){
                writer.write(str+"\r\n");
                out.flush();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    /*public static void main(String[] args){
        Build();
    }

     */
}
