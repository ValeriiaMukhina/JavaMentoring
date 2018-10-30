package restaurant.kitchen;

import restaurant.client.ObservableClient;

/**
 * Observer pattern used.
 *
 * @author  Valeriia Biruk
 * @version 1.0
 */
public interface Subject {

    void notifyOrderCompleted(ObservableClient client);
}
