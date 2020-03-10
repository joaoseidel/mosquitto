package fun.seidel.chat;

import com.google.gson.Gson;
import fun.seidel.chat.models.User;
import fun.seidel.chat.utils.ConsoleColors;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;

public class ChatListener implements MqttCallback {
    public void connectionLost(Throwable throwable) {
        System.out.println("Connection lost!");
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        String json = new String(mqttMessage.getPayload());
        User user = new Gson().fromJson(json, User.class);

        if (!user.getUsername().equalsIgnoreCase(System.getProperty("username"))) {
            System.out.println(ConsoleColors.CYAN_BOLD + user.getUsername() + " says: "
                    + ConsoleColors.RESET + user.getMessage());
        }
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    }
}
