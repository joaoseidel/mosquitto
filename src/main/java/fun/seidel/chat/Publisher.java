package fun.seidel.chat;

import com.google.gson.Gson;
import fun.seidel.chat.models.User;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Publisher {
    private User currentUser;

    public Publisher(User user) {
        this.currentUser = user;
    }

    public void sendMessage(String message) throws MqttException {
        currentUser.setMessage(message);

        String data = new Gson().toJson(currentUser);

        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setPayload(data.getBytes());

        currentUser.getClient().publish("chat", mqttMessage);
    }
}
