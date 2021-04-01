package com.parkingmanager.utils;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean isEmail(String email){
        String regex="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern= Pattern.compile(regex);
        Matcher matcher= pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isEmpty(String field,String label, HashMap<String,String> errors){
        if(field.isEmpty()){
            errors.put(label,label+" is required");
        }
        return field.isEmpty();
    }
}
