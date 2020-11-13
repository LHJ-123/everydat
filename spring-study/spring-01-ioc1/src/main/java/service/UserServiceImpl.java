package service;

import dao.UserDao;
import dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
    UserDao userDao ;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
