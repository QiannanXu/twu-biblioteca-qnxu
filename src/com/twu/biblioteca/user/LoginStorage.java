package com.twu.biblioteca.user;

import java.util.HashMap;
import java.util.Map;

public class LoginStorage {
    private static Map<String, String> userLoginInfo;

    static {
        userLoginInfo = new HashMap<String, String>(){{
           put("123-1234", "123456");
           put("123-4567", "123456");
        }};
    }

    public boolean exists(String libraryNumber, String password){
        if(userLoginInfo.containsKey(libraryNumber) && userLoginInfo.get(libraryNumber).equals(password)){
            return true;
        }
        return false;
    }
}
