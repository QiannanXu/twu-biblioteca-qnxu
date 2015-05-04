package com.twu.biblioteca.user;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private static List<User> userList;

    static {
        userList = new ArrayList<User>(){{
            add(new User("qiannan", "123-1234", "qiannan@yahoo.com", "18600000000"));
            add(new User("haha", "123-4567", "haha@yahoo.com", "18611111111"));
        }};
    }

    public String showUser(String loginNumber) {
        for(User user : userList){
            if(user.getLibraryNumber().equals(loginNumber)){
                return user.toString();
            }
        }
        return "Server Wrong!";
    }
}
