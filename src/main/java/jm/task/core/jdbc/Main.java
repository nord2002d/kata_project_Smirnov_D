package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserServiceImpl();
        userDao.createUsersTable();
        userDao.saveUser("A", "A1", (byte) 11);
        userDao.saveUser("B", "B2", (byte) 22);
        userDao.saveUser("C", "C3", (byte) 33);
        userDao.saveUser("D", "D4", (byte) 44);
        userDao.getAllUsers().forEach(System.out::println);
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
