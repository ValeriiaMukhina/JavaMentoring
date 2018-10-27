package sports.domain.user.factories;

import sports.domain.user.Admin;
import sports.domain.user.User;

public class AdminFactory implements UserFactory {

    @Override
    public User getFromConsole() {
        return new Admin();
    }
}
