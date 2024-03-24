package com.neonlab.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {


    public static boolean checkPhone(String phone){
        String regex = "^\\d{10}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

}
