package blogGUI;
import base.Post;
import base.User;
import blog.Blog;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pkw on 15年3月30日.
 */
public class BlogGUI {
    private JFrame mainFrame;

    private JPanel upperPanel;
    private JLabel postContentLbl;
    private JTextArea postContent;
    private static final int maxLen = 140;

    private JPanel buttonPanel;
    private JButton refreshBtn;
    private JButton postBtn;


    private JTextArea postArea;

    private Blog myBlog;

    public BlogGUI() {



        // set label
        postContentLbl = new JLabel("You can still input " + maxLen + "Characters");

        // set post content
        postContent = new JTextArea();
        postContent.setLineWrap(true);
        postContent.addKeyListener(new lengthListener());


        // set button
        refreshBtn = new JButton("refresh");
        postBtn = new JButton("post");
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(refreshBtn);
        buttonPanel.add(postBtn);

        postBtn.addActionListener(new postListener());
        refreshBtn.addActionListener(new refreshListener());



        // set upper panel
        upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        upperPanel.add(postContentLbl, BorderLayout.NORTH);
        upperPanel.add(postContent, BorderLayout.CENTER);
        upperPanel.add(buttonPanel, BorderLayout.SOUTH);

        //set post area
        postArea = new JTextArea("Here is my post");

        // set main frame
        mainFrame = new JFrame("user name");
        mainFrame.setSize(600, 600);

        mainFrame.setLayout(new GridLayout(2,1));
        mainFrame.add(upperPanel);
        mainFrame.add(postArea);
//        mainFrame.add(postContent);
//        mainFrame.add(refreshBtn);
//        mainFrame.add(postBtn);
//        mainFrame.add(postArea);


        mainFrame.setVisible(true);

        myBlog = new Blog(new User(111, "default", "a@hi.com"));
    }

    private void printAllPost() {
        ArrayList<Post> allPosts = myBlog.getAllPosts();
        StringBuilder allContentBuilder = new StringBuilder();
        for (int i = 0; i < allPosts.size(); i++) {
            allContentBuilder.append("Post[" + (i+1) + "]: ");
            allContentBuilder.append(allPosts.get(i).toString() + "\n");
        }
        postArea.setText(new String(allContentBuilder));
    }

    // inner class
    class postListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String content = new String();
            content = postContent.getText();
            if (content.length() > 140 || content.length() == 0) {
                return;
            }
            Post post = new Post(new Date(), content);
            myBlog.add(post);
            myBlog.save("A.blog");
            printAllPost();
            postContent.setText("");
        }
    }

    class refreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            myBlog.load("A.blog");
            printAllPost();
        }
    }

    class lengthListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent keyEvent) {
            int len = postContent.getText().length();
            if (len == 139) {
                postContent.setEditable(false);
            }
            postContentLbl.setText("You can still input " + (maxLen-len-1) + "Characters");
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            return;
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            return;
        }
    }

    public static void main1(String args[]) {
        BlogGUI blogGUI = new BlogGUI();
    }
}
