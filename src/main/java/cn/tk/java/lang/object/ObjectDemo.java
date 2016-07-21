package cn.tk.java.lang.object;

import org.junit.Test;


public class ObjectDemo {
	/**
	 * @Description:https://www.ibm.com/developerworks/cn/java/j-jtp05273/
	 */
	@Test
	public void testHashCode()
	{
		Object object = new Object();
		System.out.println(object.hashCode());
	}
	
	@Test
	public void testEquals()
	{
		Object object = new Object();
		System.out.println(this == object);
	}
	
	public boolean equals(Object object)
	{
		if (this == object) {
			return true;
		}
		if(!(object instanceof ObjectDemo))
		{
			return false;
		}
		ObjectDemo objectDemo = (ObjectDemo) object;
		return true;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
