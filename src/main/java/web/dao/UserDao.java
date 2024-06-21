package web.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

import static java.lang.Class.forName;

@Component
public class UserDao {
    private final SessionFactory sessionFactory;


//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        Session session=sessionFactory.getCurrentSession();
        return session.createQuery("from User", User.class).getResultList();
    }
    @Transactional(readOnly = true)
    public User getUserById(int id) {
        Session session=sessionFactory.getCurrentSession();
        return session.get(User.class,id);
    }
    @Transactional
    public void save(User user) {
        Session session=sessionFactory.getCurrentSession();
       session.persist(user);
    }
    @Transactional
    public void update(int id, User updateUser) {
        Session session=sessionFactory.getCurrentSession();
        User userToBeUpdate = session.get(User.class,id);
        userToBeUpdate.setName(updateUser.getName());
        userToBeUpdate.setSurname(updateUser.getSurname());
        userToBeUpdate.setAge(updateUser.getAge());
    }
    @Transactional
    public void deleteUser(int id) {
        Session session=sessionFactory.getCurrentSession();
        session.remove(session.get(User.class,id));
    }
}

