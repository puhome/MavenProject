package com.brzt.factory;

import com.brzt.entity.Users;

public class UsersFactory {
    public static Users createUsers(){
        return  new Users();
    }
}
