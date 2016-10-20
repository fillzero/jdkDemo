package cn.tk.java.util.collections;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
class TemplateTreeNode implements Comparable<TemplateTreeNode>{
	private final String name;
	private TemplateTreeNode parent;
	private List<TemplateTreeNode> children = new ArrayList<TemplateTreeNode>();
	

	public TemplateTreeNode addChildren(String name) {
		TemplateTreeNode node = new TemplateTreeNode(name);
		if(children.contains(node)) {
			return children.get(children.indexOf(node));
		}
		else {
			node.parent = this;
			children.add(node);
			return node;
		}
	}
	
	public boolean isLeafNode() {
		return children.size() == 0;
	}
	public TemplateTreeNode(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(TemplateTreeNode o) {
		return name.compareTo(o.name);
	}
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o instanceof TemplateTreeNode) {
			return this.name.equals(((TemplateTreeNode) o).name);
		}
		return false;
	}
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	public String getFullPath() {
		StringBuffer sb = new StringBuffer(name);
		TemplateTreeNode node = this;
		while(node.parent != null && !node.parent.name.equals("root")) {
			node = node.parent;
			sb.insert(0, "/");
			sb.insert(0, node.getName());
		}
		return sb.toString();
	}
	@Override
	public String toString() {
		return name + "/" + parent.name + "/" + children;
	}
	
}