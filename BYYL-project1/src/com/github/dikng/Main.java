/**
 *  项目简介写这里
 */


package com.github.dikng;


import java.util.Scanner;

/**
 *
    类描述
 *
 * @version
        2019.5.10
 * @author
        20162180133 吕翼飞 20162180146 苏春铭 */
public class Main{
        public static void main(String[] args){
                while (true) {
                        System.out.println("请选择转换功能：");
                        System.out.println("1.输入中缀表达式转换");
                        System.out.println("2.随机生成表达式");
                        Scanner sc = new Scanner(System.in);
                        int select = sc.nextInt();
                        switch (select) {
                                case 1:
                                        Readtxt.writeFile();
                                        String[] arr = Readtxt.readFile("C:\\Users\\pc\\BYYL-project1\\output.txt").split(";");
                                        //将文件中的中缀表达式通过;分隔并转换为字符串数组
                                        Transform[] test = new Transform[arr.length];
                                        /**
                                         * Transform类的方法操作
                                         */
                                        for (int i = 0; i < arr.length; i++) {
                                                test[i] = new Transform(arr[i]);
                                        }
                                        for (Transform e : test) {
                                                e.analysisString();//转换
                                        }
                                        break;
                                case 2:
                                        Builder.Build();
                                        String[] arr2 = Readtxt.readFile("C:\\Users\\pc\\BYYL-project1\\RandomOutput.txt").split(";");
                                        Transform[] test2 = new Transform[arr2.length];
                                        /**
                                         * Transform类的方法操作
                                         */
                                        for (int i = 0; i < arr2.length; i++) {
                                                test2[i] = new Transform(arr2[i]);
                                        }
                                        for (Transform e : test2) {
                                                e.analysisString();//转换
                                        }
                                        break;
                                default:
                                        System.out.println("输入错误，请重新输入！");
                                        break;
                        }
                }
        }
}
