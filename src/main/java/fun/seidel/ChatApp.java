package fun.seidel;

import fun.seidel.chat.Publisher;
import fun.seidel.chat.Subscriber;
import fun.seidel.chat.models.User;
import fun.seidel.chat.utils.ConsoleColors;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatApp {
    public static void main(String[] args) throws MqttException {
        User client = Subscriber.subscribe();

        Publisher publisher = new Publisher(client);

        while (true) {
            Scanner scan = new Scanner(System.in);

            if (scan.hasNext()) {
                publisher.sendMessage(scan.nextLine());
            }
        }
    }
}

