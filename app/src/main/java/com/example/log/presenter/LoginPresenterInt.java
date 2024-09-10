package com.example.log.presenter;

import com.example.log.model.User;

public interface LoginPresenterInt {
    interface View {
        void showLoginSuccess();
        void showLoginError(String message);
    }

    interface Presenter {
        void login(String username, String password);
    }

    interface Model {
        User getUser(String username, String password);
    }
}
