package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void update(int id, User user) {
        userDao.update(id, user);
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }


//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<User> listUsers() {
//        return entityManager.createQuery("from User").getResultList();
//    }
//
//
//    @Override
//    @Transactional
//    public void add(User user) {
//        entityManager.persist(user);
//    }
//
//    @Override
//    @Transactional
//    public void update(int id, User user) {
//        User updatedUser = entityManager.find(User.class, id);
//        updatedUser.setName(user.getName());
//        updatedUser.setLastName(user.getLastName());
//        updatedUser.setEmail(user.getEmail());
//
//        entityManager.merge(user);
//    }
//
//    @Override
//    @Transactional
//    public User getUser(int id) {
//        return entityManager.find(User.class, id);
//    }
//
//    @Override
//    @Transactional
//    public void delete(int id) {
//        entityManager.remove(entityManager.find(User.class, id));
//    }

}
