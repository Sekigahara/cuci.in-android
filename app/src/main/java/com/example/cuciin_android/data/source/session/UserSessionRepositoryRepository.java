package com.example.cuciin_android.data.source.session;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.cuciin_android.data.model.LoginObj;
import com.google.gson.Gson;

public class UserSessionRepositoryRepository implements SessionRepository<LoginObj> {
    private static UserSessionRepositoryRepository instance;
    private static String SESSION_USER = "SessionUser";
    private SharedPreferences sharedPref;

    public UserSessionRepositoryRepository(Context context)  {
        sharedPref = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public LoginObj initialize(LoginObj sessionData) {
        //save to shared preference
        setSessionData(sessionData);

        //load from shared preference
        return getSessionData();
    }

    @Override
    public LoginObj getSessionData() {
        String sessionDataJson = sharedPref.getString(SESSION_USER, null);
        if (sessionDataJson != null) {
            return new Gson().fromJson(sessionDataJson, LoginObj.class);
        }
        return null;
    }

    @Override
    public void setSessionData(LoginObj sessionData) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(SESSION_USER, new Gson().toJson(sessionData));
        editor.apply();
    }

    @Override
    public void destroy() {
        sharedPref.edit().clear().apply();
    }

    @Override
    public void update(LoginObj sessionData) {
        destroy();
        setSessionData(sessionData);
    }
}
