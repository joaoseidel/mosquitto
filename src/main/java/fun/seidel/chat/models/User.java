package fun.seidel.chat.models;

import org.eclipse.paho.client.mqttv3.MqttClient;

public class User {
    private String username;
    private String message;
    private transient MqttClient client;

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        System.setProperty("username", username);
        this.username = username;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public User setMessage(String message) {
        this.message = message;
        return this;
    }

    public MqttClient getClient() {
        return client;
    }

    public User setClient(MqttClient client) {
        this.client = client;
        return this;
    }
}
