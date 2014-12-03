import java.util.*;
public class TreeGroup implements TreeObject {
	
	private String name;		
	private TreeObject parent = null;	
	private List<TreeObject> subUsers = null;	
	private long creationTime;
	
	public TreeGroup(String name) {
		this.name = name;
		subUsers = new ArrayList<TreeObject>();
		creationTime = System.currentTimeMillis();
	}
	
	public TwitterUser getUser(String name) {
		for (TreeObject child : subUsers) {
			TwitterUser user = child.getUser(name);
			if (user != null)
				return user;
		}
		return null;
	}
	public boolean checkName(String name) {
		if (this.name.equals(name))
			return true;
		
		for (TreeObject subUser : subUsers) {
			if (subUser.checkName(name))
				return true;
		}
		
		return false;
	}
	public TreeObject getSubGroup(String name) {
		if (this.name.equals(name))
			return this;
		
		for (TreeObject child : subUsers) {
			
			TreeObject result = child.getSubGroup(name);
			if (result != null)
				return result;
		}
		return null;
	}
	public TreeObject getSubUser(int subUser) {
		if (subUser >= 0 && subUser < subUsers.size())
			return subUsers.get(subUser);
		return null;
	}

	public void add(TreeObject treeObj) {
		if (treeObj != null) {
			treeObj.setParent(this);
			subUsers.add(treeObj);
		}
	}
	public void remove(TreeObject treeObj) {
		if (treeObj != null) {
			treeObj.setParent(null);
			subUsers.remove(treeObj);
		}
	}
	public int getSubUserNum() {
		return subUsers.size();
	}
	public void setParent(TreeObject parent) {
		this.parent = parent;
	}
	public String getName() {
		return name;
	}	
	public TreeObject getParent() {
		return parent;
	}

	@Override
	public long getCreationTime() {
		return creationTime;
	}
	public long getLastUpdate(){
		return 0;
	}

}
