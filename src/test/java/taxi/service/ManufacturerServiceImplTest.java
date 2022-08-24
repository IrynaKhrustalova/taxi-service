package taxi.service;

import org.junit.jupiter.api.Test;
import taxi.lib.Injector;
import taxi.model.Manufacturer;
import static org.junit.jupiter.api.Assertions.*;

class ManufacturerServiceImplTest {
    private static final Injector injector = Injector.getInstance("taxi");
    private static final ManufacturerService manufacturerService
            = (ManufacturerService) injector.getInstance(ManufacturerService.class);

    @Test
    void create() {
        Manufacturer manufacturer = new Manufacturer("Volvo", "Swedish");
        Manufacturer actual = manufacturerService.create(manufacturer);
        assertEquals(manufacturer, actual);
    }

    @Test
    void get() {
        Manufacturer manufacturer = manufacturerService.create(new Manufacturer("Audi", "Germany"));
        Manufacturer actual = manufacturerService.get(manufacturer.getId());
        assertEquals(manufacturer, actual);
    }

    @Test
    void update() {
        Manufacturer manufacturer = manufacturerService.create(new Manufacturer("Porsche", "Germ."));
        manufacturer.setCountry("Germany");
        Manufacturer actual = manufacturerService.update(manufacturer);
        assertEquals(manufacturer, actual);
    }

    @Test
    void delete() {
        Manufacturer manufacturer = manufacturerService.create(new Manufacturer("Mersedes", "Germany"));
        assertTrue(manufacturerService.delete(manufacturer.getId()));
    }
}