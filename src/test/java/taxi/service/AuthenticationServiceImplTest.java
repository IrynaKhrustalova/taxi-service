package taxi.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import taxi.exception.AuthenticationException;
import taxi.lib.Injector;
import taxi.model.Driver;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceImplTest {
    private static final Injector injector = Injector.getInstance("taxi");
    private final AuthenticationService authenticationService
            = (AuthenticationService) injector.getInstance(AuthenticationService.class);
    private static final DriverService driverService
            = (DriverService) injector.getInstance(DriverService.class);
    private static Driver driver;

    @BeforeAll
    static void beforeAll() {
        driver = driverService
                .create(new Driver("Monica", "147", "monica@gmail.com", "monica"));
    }

    @Test
    void login_Ok() throws AuthenticationException {
        Driver monica = authenticationService
                .login("monica@gmail.com", "monica");
        assertEquals(driver, monica);
    }

    @Test
    void loginWithWrongPassword_NotOk() {
        assertThrows(AuthenticationException.class, () ->
            authenticationService.login("monica@gmail.com", "258")
        );
    }

    @Test
    void loginWithWrongLogin_NotOk() {
        assertThrows(AuthenticationException.class, () ->
                authenticationService.login("mon@gmail.com", "monica")
        );
    }
}