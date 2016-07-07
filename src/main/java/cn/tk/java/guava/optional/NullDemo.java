package cn.tk.java.guava.optional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NullDemo {
	public void testGetConnection() throws SQLException
	{
		Connection connection = null ;
		try {
			connection = DriverManager.getConnection("url", "user", "password");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String catalog = connection.getCatalog();//connection 如果不初始化为 null， 这个地方会报错
		System.out.println(catalog);
	}
}
