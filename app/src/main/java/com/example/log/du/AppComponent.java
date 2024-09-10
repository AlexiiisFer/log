package com.example.log.du;

import android.content.Context;

import com.example.log.model.DatabaseHelper;
import com.example.log.view.activities.MainActivity;

import dagger.Component;
import jakarta.inject.Singleton;


@Singleton
@Component(modules = {LoginModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);

    Context context();
    DatabaseHelper databaseHelper();

    interface View {
        void showLoginSuccess();
        void showLoginError(String message);
    }
}

