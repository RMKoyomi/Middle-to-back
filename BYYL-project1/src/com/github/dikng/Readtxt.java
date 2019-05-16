package com.github.dikng;

import java.io.*;
import java.util.Scanner;

public class Readtxt {
    /*public static void main(String[] args){
        writeFile();
        System.out.print(readFile());
    }

     */
    public static String readFile(String pathname) {
        StringBuilder result = new StringBuilder();
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
           String line;
           while ((line = br.readLine())!= null) {
               //一次读入一行数据
              result.append(System.lineSeparator()+line);
           }
           br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void writeFile() {
       Scanner sc=new Scanner(System.in);
       System.out.println("输入表达式的个数：");
       int count = sc.nextInt();
        System.out.println("输入中缀表达式：");

        try {
            File writeName = new File("C:\\Users\\pc\\BYYL-project1\\output.txt");
            writeName.createNewFile();
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ){
                for (int i = 0; i <= count; i++) {
                String input = sc.nextLine();
                writer.write(input+"\r\n");
            }
                out.flush();//把缓存内容压入文件
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
