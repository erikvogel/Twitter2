
public class TreeUser implements TreeObject {

	private TwitterUser user = null;	
	private TreeObject parent = null;	
	
	
	public TreeUser(TwitterUser user) {
		this.user = user;
	}
	
	public int getSubUserNum() {
		return 0;
	}

	public boolean checkName(String name) {
		if (user.getName().equals(name))
			return true;
		return false;
	}

	@Override
	public TreeObject getSubGroup(String name) {
		if (checkName(name))
			return this;
		return null;
	}

	@Override
	public void setParent(TreeObject parent) {
		// TODO Auto-generated method stub
		this.parent = parent;
	}

	@Override
	public TreeObject getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	public TreeObject getSubUser(int subUser) {
		return null;
	}
	
	@Override
	public TwitterUser getUser(String name) {
		if (checkName(name))
			return user;
		return null;
	}

	public void add(TreeObject treeObj) {}
	public void remove(TreeObject treeObj){}
	public String getName() {
		
		return user.getName();
	}
	public long getCreationTime(){
		return user.getCreationTime();
	}
	public long getLastUpdate(){
		return user.getLastUpdate();
	}

}
