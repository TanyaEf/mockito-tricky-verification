package pl.michalostruszka.mockito;

/**
 * Author: michal
 */
public class User {
    private final String fullName;
    private final String emailAddress;

    public User(String fullName, String emailAddress) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
    }

    public boolean hasEmailDomainBanned() {
        return emailAddress.contains("@spam.com");
    }
}
