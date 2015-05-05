package test;

import java.util.Date;

import base.User;
import base.FriendPost;

/**
 * Created by pkw on 2015/2/26.
 */
public class TestObject {
    public static void main1(String args[]) {
        User user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
        Date date = new Date();
        String content = "This is my first post!";
        FriendPost postFromFriend = new FriendPost(user, date, content);
        System.out.println(postFromFriend);
        System.out.println(postFromFriend.contains("first"));
        System.out.println(postFromFriend.contains("HKUST"));
    }
}
