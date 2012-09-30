package pl.michalostruszka.mockito;

/**
 * Author: michal
 */
public class UserRegistrationService {

    private UsersRepository usersRepository;

    public UserRegistrationService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void registerUser(User newUser) {
        if(newUser.hasEmailDomainBanned()) {
            throw new SpamProtectionException("Email address domain is blacklisted");
        }
        usersRepository.add(newUser);
    }

    public static class SpamProtectionException extends RuntimeException{

        public SpamProtectionException(String message) {
            super(message);
        }
    }

}
