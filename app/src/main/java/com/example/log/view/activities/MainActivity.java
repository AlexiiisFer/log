package com.example.log.view.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.log.R;
import com.example.log.du.AppComponent;
import com.example.log.du.DaggerAppComponent;
import com.example.log.du.LoginModule;
import com.example.log.view.fragments.LoginFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppComponent appComponent = DaggerAppComponent.builder()
                .loginModule(new LoginModule(this))
                .build();
        appComponent.inject(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new LoginFragment())
                    .commitNow();
        }
    }
}
