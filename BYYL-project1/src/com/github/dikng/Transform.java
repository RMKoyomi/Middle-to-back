package com.github.dikng;

import java.util.Stack;

public class Transform {
    private String testString = null;
    private Stack<Character> stack = null;
    /**创建要进行转换的表达式和存放运算符的栈
     *
     * @class 转换表达式
     * @author 20162180133 20162180146
     */
    public Transform(String testString){
        this.testString = testString;
        this.stack = new Stack<Character>();
    }

    public void analysisString() {
        for (int i = 0;i < testString.length(); i++) {
            char c = testString.charAt(i);  //表达式的每个字符
            if (c == '+' || c == '-') {
                //运算符为+或-的情况
                if (stack.isEmpty() || stack.peek() == '(') {
                    //若栈为空或栈顶返回一个（,将+，-进栈
                    stack.push(c);
                } else {
                    while (!stack.isEmpty()
                            && (stack.peek() == '*' || stack.peek() == '/'
                            || stack.peek() == '+' || stack.peek() == '-')) {
                        //若栈不空且栈顶返回基本运算符，打印字符
                        System.out.print(stack.pop());
                    }
                    //否则字符入栈
                    stack.push(c);
                }
            }  else if (c == '*' || c == '/') {
                //运算符为*或/时，优先级比+ /高
                    if (stack.isEmpty() || stack.peek() == '+'
                    || stack.peek() == '-' ||stack.peek() == '(') {
                        //若栈为空或栈顶返回+ - (,将*，/进栈
                        stack.push(c);
                    } else {
                        while (!stack.isEmpty()
                        && (stack.peek() == '/' || stack.peek() == '*')) {
                            //若栈不空且栈顶为* /，打印字符
                            System.out.print(stack.pop());
                        }
                        //否则字符入栈
                        stack.push(c);
                    }
                } else if (c == '(') {
                //( 优先进栈
                        stack.push(c);
            } else if (c == ')') {
                //当运算符为) 若栈顶元素不为（ 输出该字符
                char temp = ' ';
                while ((temp = stack.pop()) != '(') {
                    System.out.print(temp);
                }
            } /*else if (c == ';') {
                stack.push(c);
                System.out.print("\r\n");
            }*/else {
                System.out.print(c);
            }
            }
        if (!stack.isEmpty()) {
            //输出除运算符外的字符
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }
        }
    /*public static void main(String[] args) {
        Transform[] arr=new Transform[2];
      arr[0] = new Transform( "A+B*(C-D)/E+F/H");
      arr[1] = new Transform("C+D");
      for(Transform e:arr){
          e.analysisString();
      }
    }

     */



    }


