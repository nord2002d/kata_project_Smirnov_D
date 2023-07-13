package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

public class Main {

    public static void main(String[] args) {
        UserDaoHibernateImpl u = new UserDaoHibernateImpl();
        u.saveUser("www","qweq", (byte) 45);
        u.saveUser("QQQ","PP", (byte) 34);
        u.getAllUsers().forEach(System.out::println);

    }
}
