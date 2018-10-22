package exercise6.kitchen;

import exercise6.client.ObservableClient;

public interface Subject {

    void register(ObservableClient client);
    void unregister(ObservableClient client);

    void notifyOrderCompleted();

    String getUpdate();
}
