package com.example.log.model;

import java.sql.SQLException;

import com.example.log.presenter.RegisterPresenterInt;
import com.j256.ormlite.dao.Dao;

public class RegisterModel implements RegisterPresenterInt.Model {
    private final Dao<User, Integer> userDao;

    public RegisterModel(Dao<User, Integer> userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        try {
            userDao.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isUserExists(String username) {
        try {
            return userDao.queryBuilder().where().eq("username", username).queryForFirst() != null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


