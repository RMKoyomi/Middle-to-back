/**
 *  项目简介写这里
 */


package com.github.dikng;


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
                Readtxt.writeFile();
                String [] arr=Readtxt.readFile().split(";");
                //将文件中的中缀表达式通过;分隔并转换为字符串数组
                Transform[] test=new Transform[arr.length];
                /**
                 * Transform类的方法操作
                 */
                for(int i=0;i<arr.length;i++){
                        test[i]=new Transform(arr[i]);
                }
                for(Transform e:test){
                        e.analysisString();//转换
                }
        }
}
