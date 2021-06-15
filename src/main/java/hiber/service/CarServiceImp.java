package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CarServiceImp implements CarService{
    @Autowired
    CarDao carDao;

    @Transactional
    @Override
    public Car add(Car car) {
        carDao.add(car);
        return car;
    }
}
