package pl.michalostruszka.mockito;

/**
 * Author: michal
 */
public class UsersRepository {

    // beware: method declared final!
    public final void add(User newUser) {
        System.out.println("persistent storage call will be here");
    }

}
