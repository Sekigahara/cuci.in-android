package com.example.cuciin_android.utils.utility;

import com.example.cuciin_android.data.model.login.LoginObj;
import com.example.cuciin_android.utils.session.UserSessionRepositoryRepository;

public class UserSessionUtil {
    private static UserSessionRepositoryRepository userSessionRepositoryRepository;

    public UserSessionUtil(UserSessionRepositoryRepository userSessionRepositoryRepository){
        this.userSessionRepositoryRepository = userSessionRepositoryRepository;
    }

    public void setSession(LoginObj loginObj){
        userSessionRepositoryRepository.setSessionData(loginObj);
    }

    public UserSessionRepositoryRepository getSession(){
        return userSessionRepositoryRepository;
    }

    public void updateSession(LoginObj loginObj){
        userSessionRepositoryRepository.update(loginObj);
    }

    public void logout(){
        userSessionRepositoryRepository.destroy();
    }
}
