package test;

import java.io.*;
import java.util.Date;

import base.*;
import blog.*;
/**
 * Created by pkw on 15年3月3日.
 */
public class TestBlog {
    public String getInput() {
        String line = "";
        System.out.print("Enter the prompt: ");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
    public static void main1(String[] args) {
        TestBlog testBlog = new TestBlog();
        User user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
        Blog myBlog = new Blog(user);
        String prompt = null;

        while (!(prompt = testBlog.getInput()).equals("exit")) {
            if (prompt.startsWith("list")) {
                myBlog.list();
            } else if (prompt.startsWith("post")) {
                String content = prompt.substring(5);
                Date date = new Date();
                myBlog.post(new Post(date, content));
            } else if (prompt.startsWith("delete")) {
                int index = Integer.parseInt(prompt.split(" ")[1]) - 1;
                myBlog.delete(index);
            }
        }
    }
}
