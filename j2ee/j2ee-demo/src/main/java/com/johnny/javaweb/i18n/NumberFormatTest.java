package com.johnny.javaweb.i18n;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest {

    public static void main(String[] args) throws ParseException {
        int price = 89;

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String result = nf.format(price);
        System.out.println(result);

        String s = "￥89.00";
        nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
        Number n = nf.parse(s);
        System.out.println(n.doubleValue() + 1);

        double num = 0.5;
        nf = NumberFormat.getPercentInstance();
        System.out.println(nf.format(num));
    }
}