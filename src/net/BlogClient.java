package net;

import base.Post;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * Created by pkw on 15年4月27日.
 */
public class BlogClient {
    public static final String IP = "127.0.0.1";
    public static final int PORT = 3021;

    public static void main(String args[]) {
        Socket clientSocket;
        try {
            clientSocket = new Socket(IP, PORT);
            PrintWriter toServer = new PrintWriter(new BufferedOutputStream(clientSocket.getOutputStream()));
            Post post = new Post(new Date(), "hello");
            toServer.write(post.toString());
            toServer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
