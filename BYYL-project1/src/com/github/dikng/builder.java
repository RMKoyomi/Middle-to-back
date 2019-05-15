package com.github.dikng;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.regex.Pattern;

public class builder {
    public static void main(String[] args) {
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String regex = "[[(]{0,}[A-Z]|[0-9]|[a-z]{1,}[+'-'/*]{1}[A-Z]|[0-9]|[a-z]{1,}[)]{0,}[+'-'*/]{0,1}]+\\s$";
        Pattern pattern = Pattern.compile(regex);
        String genr = new String(array, Charset.forName("UTF-8"));
        System.out.println(genr);
    }
}
