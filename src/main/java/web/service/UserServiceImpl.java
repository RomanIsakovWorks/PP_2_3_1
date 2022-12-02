package web.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserServiceImpl implements UserService{

    private final SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    @Override
//    @Transactional(readOnly = true)
//    public List<User> listUsers() {
//        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
//        return query.getResultList();
//    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

//    @Override
//    @Transactional
//    public void add(User user) {
//        sessionFactory.getCurrentSession().save(user);
//    }

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

//    @Override
//    @Transactional
//    public void update(int id, User user) {
//        Session session = sessionFactory.getCurrentSession();
//        User updatedUser = session.get(User.class, id);
//
//        updatedUser.setName(user.getName());
//        updatedUser.setLastName(user.getLastName());
//        updatedUser.setEmail(user.getEmail());
//    }

    @Override
    @Transactional
    public void update(int id, User user) {
        User updatedUser = entityManager.find(User.class, id);
        updatedUser.setName(user.getName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());

        entityManager.merge(user);
    }

//    @Override
//    @Transactional
//    public User getUser(int id) {
//        User user = new User();
//        user = (User)sessionFactory.getCurrentSession().createQuery("FROM User user where user.id = :id").setParameter("id", id).getSingleResult();
//        return user;
//    }

    @Override
    @Transactional
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

//    @Override
//    @Transactional
//    public void delete(int id) {
//        sessionFactory.getCurrentSession().remove(sessionFactory.getCurrentSession().get(User.class, id));
//    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

}
