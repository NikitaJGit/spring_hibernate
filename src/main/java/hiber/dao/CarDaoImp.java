package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {


    @Override
    public void add(Car car) {
//        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<Car> getCar() {
//        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("FROM Car");
//        return query.getResultList();
        return null;
    }
}
