package com.example.log.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "users")
public class User {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String username;

    @DatabaseField(canBeNull = false)
    private String password;

    public User() {
        // ORMLite nécessite un constructeur sans arguments
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters et Setters
}

