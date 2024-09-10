package com.example.log.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import com.example.log.R;
import com.example.log.presenter.LoginPresenterInt;
import com.example.log.model.DatabaseHelper;
import com.example.log.model.LoginModel;
import com.example.log.presenter.LoginPresenter;

import java.sql.SQLException;

import javax.inject.Inject;

public class LoginFragment extends Fragment implements LoginPresenterInt.View {


    private EditText usernameInput;
    private EditText passwordInput;

    @Inject
    LoginPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        usernameInput = view.findViewById(R.id.username);
        passwordInput = view.findViewById(R.id.password);

        DatabaseHelper dbHelper = new DatabaseHelper(getActivity());
        LoginModel model = null;
        try {
            model = new LoginModel(dbHelper.getUserDao());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        presenter = new LoginPresenter(this, model);

        view.findViewById(R.id.login_button).setOnClickListener(v -> {
            String username = usernameInput.getText().toString();
            String password = passwordInput.getText().toString();
            presenter.login(username, password);
        });

        view.findViewById(R.id.go_to_register).setOnClickListener(v -> {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, new RegisterFragment())
                    .commit();
        });

        return view;
    }

    @Override
    public void showLoginSuccess() {
        // Rediriger vers le fragment de bienvenue en passant le nom d'utilisateur
        String username = usernameInput.getText().toString();
        WelcomeFragment welcomeFragment = WelcomeFragment.newInstance(username);

        getFragmentManager().beginTransaction()
                .replace(R.id.container, welcomeFragment)
                .commit();
    }

    @Override
    public void showLoginError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}

