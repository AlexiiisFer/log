package com.example.log.presenter;


import com.example.log.model.User;

public class RegisterPresenter implements RegisterPresenterInt.Presenter {
    private RegisterPresenterInt.View view;
    private RegisterPresenterInt.Model model;

    public RegisterPresenter(RegisterPresenterInt.View view, RegisterPresenterInt.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void register(String username, String password) {
        if (model.isUserExists(username)) {
            view.showRegisterError("Ce nom est déjà utilisé");
        } else {
            model.addUser(new User(username, password));
            view.showRegisterSuccess();
        }
    }
}



