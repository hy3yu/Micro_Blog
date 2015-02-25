package base;
import java.util.Date;

public class Post {
	private Date date;
	private String content;
	
	/**
	 * Constructor
	 * @param date
	 * @param content
	 */
	public Post(Date date, String content) {
		this.date = date;
		this.content = content;
	}

    /**
     * Default Constructor
     */
    public Post() {
    }

    /**
	 * 
	 * @return the content of the blog
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 
	 * @return the date of the blog
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * 
	 */
	public String toString() {
		String dateString = date.toString();
		return dateString + " " + content;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ans = true;
		
		if (o == null) {
			return false;
		}
		
		if(o.getClass().equals(this.getClass())) {
			return false;
		}
		Post post = (Post) o;

		if (date.equals(post.getDate()) && content.equals(post.getContent())) {
			ans = true;
		}
		
		return ans;
	}
	
	/**
	 * 
	 */
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	
	/**
	 * check whether this post contain some key words
	 * @param keyWords
	 * @return 
	 */
	public boolean contains(String keyWords) {
		return content.contains(keyWords);
	}
	
	
}
