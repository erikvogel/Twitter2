
public class Tree {

	private static Tree tree= null;	
	private TreeObject root;	
	
	private Tree() {
		root = new TreeGroup("Root");
	}
	public boolean addGroup(String groupName, String parentGroup) {
		if (root.checkName(groupName))
			return false;
		
		TreeObject parent = root.getSubGroup(parentGroup);
		if (parent instanceof TreeGroup)
			parent.add(new TreeGroup(groupName));
		else
			return false;
		
		return true;
	}

	public boolean addUser(String userName, String groupName) {
		if (root.checkName(userName))
			return false;
		
		TreeObject group = root.getSubGroup(groupName);
		if ((group != null) && (group instanceof TreeGroup))
			group.add(new TreeUser(new TwitterUser(userName)));
		else
			return false;
		return true;
	}
	
	public TwitterUser getUser(String userName) {
		return root.getUser(userName);
	}
	public boolean removeGroup(String groupName) {

		if (groupName.equalsIgnoreCase("root") || !(root.checkName(groupName)))
			return false;
		
		TreeObject group = root.getSubGroup(groupName);
		if (group instanceof TreeGroup) {
			TreeObject parent = group.getParent();
			for (int i = 0; i < group.getSubUserNum(); i++) {
				parent.add(group.getSubUser(i));
			}
			parent.remove(group);
		}
		else
			return false;
		
		return true;
	}
	public boolean removeUser(String userName) {
		if (!(root.checkName(userName)))
			return false;
		
		TreeObject leaf = (TreeObject) root.getUser(userName);
		TwitterUser user = leaf.getUser(userName);
		if (user != null) {
			for (String following : user.getFollowing())
				root.getUser(following).deleteFollowing(user);
			leaf.getParent().remove(leaf);
		}
		else
			return false;
		return true;
	}
	public static Tree getInstance() {
		if (tree == null)
			tree = new Tree();
		return tree;
	}
	public TreeObject getRoot(){
		return root;
	}
}
