package com.example.log.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import com.example.log.R;
import com.example.log.presenter.RegisterPresenterInt;
import com.example.log.model.DatabaseHelper;
import com.example.log.model.RegisterModel;
import com.example.log.presenter.RegisterPresenter;

import java.sql.SQLException;

public class RegisterFragment extends Fragment implements RegisterPresenterInt.View {

    private RegisterPresenter presenter;
    private EditText usernameInput;
    private EditText passwordInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        usernameInput = view.findViewById(R.id.username);
        passwordInput = view.findViewById(R.id.password);

        DatabaseHelper dbHelper = new DatabaseHelper(getActivity());
        RegisterModel model = null;
        try {
            model = new RegisterModel(dbHelper.getUserDao());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        presenter = new RegisterPresenter(this, model);

        view.findViewById(R.id.register_button).setOnClickListener(v -> {
            String username = usernameInput.getText().toString();
            String password = passwordInput.getText().toString();
            presenter.register(username, password);
        });
        view.findViewById(R.id.back_to_login).setOnClickListener(v -> {
            // Revenir au fragment de login
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, new LoginFragment())
                    .commit();
        });

        return view;
    }

    @Override
    public void showRegisterSuccess() {
        Toast.makeText(getActivity(), "Registration successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRegisterError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
