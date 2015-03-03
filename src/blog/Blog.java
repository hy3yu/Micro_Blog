package blog;

import base.Post;
import base.User;

import java.util.ArrayList;

/**
 * Created by pkw on 15年3月3日.
 */
public class Blog {
    private User user;
    private ArrayList<Post> allPosts;

    public Blog(User user) {
        this.user = user;
        allPosts = new ArrayList<Post>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Post> getAllPosts() {
        return allPosts;
    }

    public void setAllPosts(ArrayList<Post> allPosts) {
        this.allPosts = allPosts;
    }

    public void post(Post p) {
        allPosts.add(p);
        System.out.println("A new Post: ");
        System.out.println(p.toString());
    }

    public void list() {
        System.out.println("Current posts:");
        for (int i = 0; i < allPosts.size(); i++) {
            System.out.print("Post[" + (i+1) + "]: ");
            System.out.println(allPosts.get(i).toString());
        }
    }

    public void delete(int index) {
        try {
            allPosts.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index is out of bound!");
        }
    }

    @Override
    public int hashCode() {
        return user.hashCode()<<16 ^ allPosts.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(user.toString());
        for (Post post : allPosts) {
            stringBuilder.append("\n");
            stringBuilder.append(post.toString());
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!obj.getClass().equals(this.getClass()))
            return false;

        Blog b = (Blog) obj;
        return (b.getUser().equals(user) && b.getAllPosts().equals(allPosts));
    }
}
