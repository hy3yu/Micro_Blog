package base;

import java.util.Date;

/**
 * Created by pkw on 2015/2/25.
 */
public class FriendPost extends Post{
    private User friend;

    public FriendPost(User friend, Date date, String content) {
        this.friend = friend;
        this.setContent(content);
        this.setDate(date);
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FriendPost that = (FriendPost) o;

        if (friend != null ? !friend.equals(that.friend) : that.friend != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (friend != null ? friend.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return friend.toString() + "\n" + super.toString();
    }
}
