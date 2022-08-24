package taxi.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taxi.dao.CarDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Car;
import taxi.model.Driver;

@Service
public class CarServiceImpl implements CarService {
    private static final Logger logger = LogManager.getLogger(CarServiceImpl.class);
    @Inject
    private CarDao carDao;

    @Override
    public void addDriverToCar(Driver driver, Car car) {
        logger.info("Method addDriverToCar was called. Params: driver={}, car={}", driver, car);
        car.getDrivers().add(driver);
        carDao.update(car);
    }

    @Override
    public void removeDriverFromCar(Driver driver, Car car) {
        logger.info("Method removeDriverFromCar was called. "
                + "Params: driver={}, car={}", driver, car);
        car.getDrivers().remove(driver);
        carDao.update(car);
    }

    @Override
    public List<Car> getAllByDriver(Long driverId) {
        logger.info("Method getAllByDriver was called. Params: driverId={}", driverId);
        return carDao.getAllByDriver(driverId);
    }

    @Override
    public Car create(Car car) {
        logger.info("Method create was called. Params: car={}", car);
        return carDao.create(car);
    }

    @Override
    public Car get(Long id) {
        logger.info("Method get Car was called. Params: carId={}", id);
        return carDao.get(id).get();
    }

    @Override
    public List<Car> getAll() {
        logger.info("Method gerAll cars was called.");
        return carDao.getAll();
    }

    @Override
    public Car update(Car car) {
        logger.info("Method update car was called. Params: car={}", car);
        return carDao.update(car);
    }

    @Override
    public boolean delete(Long id) {
        logger.info("Method delete Car was called. Params: carId={}", id);
        return carDao.delete(id);
    }
}
