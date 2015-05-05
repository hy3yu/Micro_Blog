package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pkw on 15年4月27日.
 */
public class BlogServer {
    public static final int PORT = 3021;

    public static void main1(String args[]) {
        ServerSocket serverSocket;
        Socket clientSocket = null;
        try {
            serverSocket = new ServerSocket(3021);
            System.out.println("Server started...");
            System.out.println("waiting for client...");
            clientSocket = serverSocket.accept();
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String postString = new String();
            String tmp;
            while ((tmp = fromClient.readLine()) != null) {
                postString += tmp + "\n";
            }
            System.out.println(postString);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
