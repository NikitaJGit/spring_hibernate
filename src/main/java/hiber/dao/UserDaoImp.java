package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
      private SessionFactory sessionFactory;

      @Autowired
      public void setSessionFactory(SessionFactory sessionFactory){
         this.sessionFactory = sessionFactory;
      }

      @Transactional
      @Override
      public void add(User user) {
         Session session = sessionFactory.getCurrentSession();
         session.save(user);
      }

      @Override
      @SuppressWarnings("unchecked")
      public List<User> listUsers() {
         Session session = sessionFactory.getCurrentSession();
         TypedQuery query = session.createQuery("from User ");
         return (List<User>) query.getResultList();
      }

      @Override
      @SuppressWarnings("unchecked")
      public User findOwner(String model, int series) {
         Session session = sessionFactory.getCurrentSession();
          TypedQuery query = session.createQuery("from User where car.model = :model and car.series = :series")
                 .setParameter("model", model)
                 .setParameter("series", series);
         List<User> userList = query.getResultList();

         return userList.stream().findAny().orElse(null);
      }

}
