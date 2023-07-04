package controller;

import model.dao.UserDao;

import java.sql.SQLException;

public class UserController {

    public Long logar(String login_user, String password_user) throws SQLException {
        UserDao userDao = new UserDao();
        return userDao.logar(login_user, password_user);
    }
}
