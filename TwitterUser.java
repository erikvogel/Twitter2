import java.util.*;

public class TwitterUser {
	
	private long creationTime;
	private long lastUpdate;
	private String name;
	private List<String> followers;
	private List<String> following;
	private List<Message> feed;
	
	public TwitterUser(String name){
		this.name = name;
		followers = new LinkedList<String>();
		following = new LinkedList<String>();
		feed = new LinkedList<Message>();
		creationTime = System.currentTimeMillis();
		lastUpdate = 0;
	}

	public void postMessage(String msg) {
		Message message = new Message(name, msg);
		feed.add(message);
	}
	public void update(TwitterUser user , Message msg) {
		if (msg == null) {
			following.remove(user.name);
		}
		else {
			feed.add(msg);
		}
		lastUpdate = System.currentTimeMillis(); 
	}
	
	public void addFollowing(TwitterUser parent){
		following.add(parent.getName());
		parent.followers.add(this.getName());
	}
	public void deleteFollowing(TwitterUser follower) {
		
		followers.remove(follower.getName());
		follower.following.remove(name);
	}
	public String getName() {
		return name;
	}

	public long getCreationTime() {
		return creationTime;
	}

	public List<String> getFollowers() {
		return followers;
	}

	public List<String> getFollowing() {
		return following;
	}

	public List<Message> getFeed() {
		return feed;
	}
	public long getLastUpdate() {
		return lastUpdate;
	}

	
}
