package restaurant.client;

import restaurant.kitchen.Subject;

/**
 * @author  Valeriia Biruk
 * @version 1.0
 */
public interface ObservableClient {
   void update(Subject subject);
   String getName();
}
