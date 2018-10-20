package exercise6.client;

import exercise6.kitchen.Subject;

public interface ObservableClient {
   void update(Subject subject);
   String getName();
}