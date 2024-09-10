package com.example.log.presenter;

import com.example.log.model.User;

public interface LoginPresenterInt {
    interface View {
        void showLoginSuccess();
        void showLoginError(String message);
    }


    interface Model {
        User getUser(String username, String password);
    }
}
