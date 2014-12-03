
public interface TreeObject {	
		
		public TreeObject getSubUser(int subUser);
		
		public void add(TreeObject treeObj);
		
		public void remove(TreeObject treeObj);
		
		public boolean checkName(String name);
		
		public TreeObject getSubGroup(String id);
		
		public void setParent(TreeObject parent);
		
		public TreeObject getParent();
	
		public TwitterUser getUser(String id);
		
		public String getName();
		
		public int getSubUserNum();
		
		public long getCreationTime();
		
		public long getLastUpdate();
	}

