package pl.michalostruszka.mockito;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Author: michal
 */
public class UserRegistrationServiceTest {

    private UsersRepository usersRepository;
    private UserRegistrationService registrationService;

    @Before
    public void setUp() throws Exception {
        usersRepository = mock(UsersRepository.class);
        registrationService = new UserRegistrationService(usersRepository);
    }

    @Test
    public void shouldStoreRegisteredUser() throws Exception {
        User newUser = new User("John Doe", "user@gmail.com");
        registrationService.registerUser(newUser);
        verify(usersRepository).add(newUser);
    }

    @Test(expected = UserRegistrationService.SpamProtectionException.class)
    public void shouldNotRegisterUserIfEmailIsBlacklisted() throws Exception {
        User newUser = new User("John Doe", "user@spam.com");
        try {
            registrationService.registerUser(newUser);
        } finally {
            verifyZeroInteractions(usersRepository);
        }
    }

}
