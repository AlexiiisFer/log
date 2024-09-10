package com.example.log.model;

import com.example.log.presenter.LoginPresenterInt;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

public class LoginModel implements LoginPresenterInt.Model {
    private final Dao<User, Integer> userDao;

    public LoginModel(Dao<User, Integer> userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(String username, String password) {
        try {
            return userDao.queryBuilder().where().eq("username", username).and().eq("password", password).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
