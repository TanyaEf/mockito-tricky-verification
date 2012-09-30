package pl.michalostruszka.mockito;

/**
 * Author: michal
 */
public class UsersRepository {

    public void add(User newUser) {
        System.out.println("persistent storage call will be here");
    }

}
