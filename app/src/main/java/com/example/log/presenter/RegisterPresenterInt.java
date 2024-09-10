package com.example.log.presenter;

import com.example.log.model.User;

public interface RegisterPresenterInt {
    interface View {
        void showRegisterSuccess();
        void showRegisterError(String message);
    }

    interface Presenter {
        void register(String username, String password);
    }

    interface Model {
        void addUser(User user);
        boolean isUserExists(String username);
    }
}

