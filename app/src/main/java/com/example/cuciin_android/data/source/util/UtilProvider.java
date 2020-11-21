package com.example.cuciin_android.data.source.util;

import android.content.Context;

import com.example.cuciin_android.data.source.session.UserSessionRepositoryRepository;

public class UtilProvider {
    private static UserSessionUtil userSessionUtil;

    public static void initUserSession(Context context){
        UserSessionRepositoryRepository userSession = new UserSessionRepositoryRepository(context);
        userSessionUtil = new UserSessionUtil(userSession);
    }

    public static UserSessionUtil getUserSessionUtil(){
        return userSessionUtil;
    }
}
