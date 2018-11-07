package sports.domain.user.factories;

import sports.domain.user.Admin;
import sports.domain.user.User;

/**
 * Abstract Factory pattern used for admin creation.
 * @author  Valeriia Biruk
 * @version 1.0
 */
public class AdminFactory implements UserFactory {

    @Override
    public User getFromConsole() {
        return new Admin();
    }
}
