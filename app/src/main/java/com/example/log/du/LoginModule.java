package com.example.log.du;

import android.content.Context;

import com.example.log.model.DatabaseHelper;
import com.example.log.presenter.LoginPresenter;
import com.example.log.presenter.LoginPresenterInt;

import dagger.Module;
import dagger.Provides;
import jakarta.inject.Singleton;


@Module
public class LoginModule {
    private final Context context;

    public LoginModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    DatabaseHelper provideDatabaseHelper(Context context) {
        return new DatabaseHelper(context);
    }

    @Provides
    public LoginPresenter provideLoginPresenter(LoginPresenterInt.View view, LoginPresenterInt.Model model) {
        return new LoginPresenter(view, model);
    }


    

}
