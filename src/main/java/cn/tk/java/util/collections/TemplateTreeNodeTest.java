package cn.tk.java.util.collections;

import org.junit.Test;

public class TemplateTreeNodeTest {
	private static TemplateTreeNode root = new TemplateTreeNode("root");
	private static TemplateTreeNode zhang = new TemplateTreeNode("zhang");
	private static TemplateTreeNode li = new TemplateTreeNode("li");
	private static TemplateTreeNode wang = new TemplateTreeNode("v");
	private static TemplateTreeNode zhang31 = new TemplateTreeNode("zhang31");
	private static TemplateTreeNode zhang32 = new TemplateTreeNode("zhang32");
	private static TemplateTreeNode zhang33 = new TemplateTreeNode("zhang33");
	private static TemplateTreeNode li41 = new TemplateTreeNode("li41");
	private static TemplateTreeNode li42 = new TemplateTreeNode("li42");
	private static TemplateTreeNode li43 = new TemplateTreeNode("li43");
	private static TemplateTreeNode wang51 = new TemplateTreeNode("wang51");
	private static TemplateTreeNode wang52 = new TemplateTreeNode("wang52");
	private static TemplateTreeNode wang53 = new TemplateTreeNode("wang53");
	
	static{
		zhang = root.addChildren("zhang3");
		li = root.addChildren("li4");
		wang = root.addChildren("wang5");
		zhang31 = zhang.addChildren("zhang31");
		zhang32 = zhang.addChildren("zhang32");
		zhang33 = zhang.addChildren("zhang33");
		li41 = li.addChildren("li41");
		li42 = li.addChildren("li42");
		li43 = li.addChildren("li43");
		wang51 = wang.addChildren("wang51");
		wang52 = wang.addChildren("wang52");
		wang53 = wang.addChildren("wang53");
	}
		
	@Test
	public void testCompare()
	{
		System.out.println("lijinlong".compareTo("lijinlong"));
		System.out.println("lijinlong".compareTo("wangwenchao"));
		System.out.println("wangwenchao".compareTo("lijinlong"));
	}
	
	@Test
	public void testIsLeafNode()
	{
		System.out.println(root.isLeafNode());
		System.out.println(li.isLeafNode());
		System.out.println(li41.isLeafNode());
	}
	
	@Test
	public void testAddChildren()
	{
		System.out.println(root);
	}
}
