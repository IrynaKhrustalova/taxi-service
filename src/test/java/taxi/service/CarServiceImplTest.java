package taxi.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import taxi.lib.Injector;
import taxi.model.Car;
import taxi.model.Driver;
import taxi.model.Manufacturer;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CarServiceImplTest {
    private static final Injector injector = Injector.getInstance("taxi");
    private static final ManufacturerService manufacturerService
            = (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private final CarService carService = (CarService) injector.getInstance(CarService.class);
    private static final DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
    private static Driver driver;
    private static Manufacturer manufacturer;

    @BeforeAll
    static void beforeAll() {
        manufacturer = manufacturerService.create(new Manufacturer("Skoda", "Czech republic"));
        driver = new Driver("Bill", "123", "bill@gmail.com", "8894");
        driverService.create(driver);
    }

    @Test
    public void create_Ok() {
        Car car = new Car("Scala", manufacturer);
        Car actual = carService.create(car);
        assertEquals(car, actual);
    }

    @Test
    public void addDriverToCar_Ok() {
        Car car = carService.create(new Car("Slavia", manufacturer));
        carService.addDriverToCar(driver, car);
        List<Driver> drivers = car.getDrivers();
        assertEquals(drivers.size(), 1);
        assertEquals(drivers.get(0), driver);
    }

    @Test
    void getAllByDriver_Ok() {
        Car car1 = carService.create(new Car("Superb sportline", manufacturer));
        Car car2 = carService.create(new Car("Superb estate", manufacturer));
        Driver driver1 = driverService
                .create(new Driver("Poll", "258", "poll@gmail.com", "369"));
        carService.addDriverToCar(driver1, car1);
        carService.addDriverToCar(driver1, car2);
        List<Car> allByDriver = carService.getAllByDriver(driver1.getId());
        assertEquals(2, allByDriver.size());
    }

    @Test
    void removeDriverFromCar_Ok() {
        Car car = carService.create(new Car("Octavia combi", manufacturer));
        carService.addDriverToCar(driver, car);
        carService.removeDriverFromCar(driver, car);
        List<Driver> actual = car.getDrivers();
        assertEquals(0, actual.size());
    }


    @Test
    void get_Ok() {
        Car car = carService.create(new Car("Superb hybrid", manufacturer));
        Car actual = carService.get(car.getId());
        assertEquals(car, actual);
    }

    @Test
    void update_Ok() {
        Car car = carService.create(new Car("Superb", manufacturer));
        car.setModel("Superb combi");
        assertEquals(car, carService.update(car));
    }

    @Test
    void delete_Ok() {
        Car car = carService.create(new Car("Superb", manufacturer));
        assertTrue(carService.delete(car.getId()));
    }
}