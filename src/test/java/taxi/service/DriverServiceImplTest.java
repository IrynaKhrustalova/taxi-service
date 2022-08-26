package taxi.service;

import org.junit.jupiter.api.Test;
import taxi.lib.Injector;
import taxi.model.Driver;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DriverServiceImplTest {
    private static final Injector injector = Injector.getInstance("taxi");
    private static final DriverService driverService
            = (DriverService) injector.getInstance(DriverService.class);

    @Test
    void create_Ok() {
        Driver driver = new Driver("Ivan", "753", "ivan@gmail.com", "2587");
        Driver actual = driverService.create(driver);
        assertEquals(driver, actual);
    }

    @Test
    void get_Ok() {
        Driver driver = driverService
                .create(new Driver("Anna", "147", "anna@gmail.com", "2589"));
        Driver actual = driverService.get(driver.getId());
        assertEquals(driver, actual);
    }

    @Test
    void update_Ok() {
        Driver driver = driverService
                .create(new Driver("Lucia", "444", "lucia@gmail.com", "024"));
        driver.setPassword("098");
        Driver actual = driverService.update(driver);
        assertEquals(driver, actual);
    }

    @Test
    void delete_Ok() {
        Driver driver = driverService
                .create(new Driver("Fedor", "999", "fedor@gmail.com", "987"));
        assertTrue(driverService.delete(driver.getId()));
    }

    @Test
    void findByLogin_Ok() {
        Driver driver = driverService
                .create(new Driver("Tomas", "278", "tomas@gmail.com", "654"));
        Optional<Driver> actual = driverService.findByLogin("tomas@gmail.com");
        assertEquals(driver, actual.get());
    }
}