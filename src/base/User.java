package base;

import java.io.Serializable;
import java.util.Comparator;

public class User implements Comparable<User>, Serializable {
    private int userId;
    private String userName;
    private String userEmail;

    public User(int userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "User [" +
                "userId=" + userId +
                ", userName=" + userName +
                ", userEmail=" + userEmail +
                ']';
    }

    public int compareTo(User u) {
        if (userId > u.userId)
            return 1;
        else if (userId == u.userId)
            return 0;
        else
            return -1;
    }
}
