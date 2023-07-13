package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {


    @Override
    public void createUsersTable() {
        Session session = Util.getSession(Util.getProperties());
        session.beginTransaction();
        String sql = "CREATE TABLE IF NOT EXISTS users(" +
                "id INT NOT NULL AUTO_INCREMENT, " +
                "name TINYTEXT NOT NULL, " +
                "last_name TINYTEXT NOT NULL, " +
                "age INT NOT NULL, " +
                "PRIMARY KEY(id))";
        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSession(Util.getProperties());
        session.beginTransaction();
        String sql = "DROP TABLE IF EXISTS users";
        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSession(Util.getProperties());
        session.beginTransaction();
        User user = new User(name,lastName,age);
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getSession(Util.getProperties());
        session.beginTransaction();
        User user = new User();
        user.setId(id);
        session.remove(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = Util.getSession(Util.getProperties())) {
            Query<User> query = session.createQuery("from users", User.class);
            return query.list();
        }
    }

    @Override
    public void cleanUsersTable() {

    }
}
