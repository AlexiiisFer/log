package com.example.log.presenter;

import com.example.log.model.User;

import javax.inject.Inject;

public class LoginPresenter implements LoginPresenterInt{
    private final LoginPresenterInt.View view;
    private final LoginPresenterInt.Model model;


    @Inject
    public LoginPresenter(LoginPresenterInt.View view, LoginPresenterInt.Model model) {
        this.view = view;
        this.model = model;
    }



    public void login(String username, String password) {
        User user = model.getUser(username, password);
        if (user != null) {
            view.showLoginSuccess();
        } else {
            view.showLoginError("Mauvais identifiants");
        }
    }
}

