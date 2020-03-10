package fun.seidel.chat;

import fun.seidel.chat.models.User;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.Scanner;

public class Subscriber {
    public static User subscribe() throws MqttException {
        MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
        client.setCallback(new ChatListener());
        client.connect();

        client.subscribe("chat");

        System.out.print("What's your name? ");
        Scanner scan = new Scanner(System.in);

        User user = new User()
                .setUsername(scan.next())
                .setClient(client);

        System.out.println("\n\nHey, "+ user.getUsername() +"!\nWelcome to the chat!\t");
        return user;
    }
}
