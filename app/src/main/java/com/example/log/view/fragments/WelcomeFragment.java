package com.example.log.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.example.log.R;

public class WelcomeFragment extends Fragment {

    private static final String ARG_USERNAME = "username";
    private String username;

    public static WelcomeFragment newInstance(String username) {
        WelcomeFragment fragment = new WelcomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USERNAME, username);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            username = getArguments().getString(ARG_USERNAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        // Récupérer le TextView et afficher le message de bienvenue
        TextView welcomeTextView = view.findViewById(R.id.welcome_message);
        welcomeTextView.setText("Bonjour " + username);

        return view;
    }
}
