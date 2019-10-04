package jdbcdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


/**
 * @author Administrator 演示示例5：SQL注入隐患
 */
public class demo5 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbcdemo", "root", "123456");
			stmt = conn.createStatement();

			System.out.println("*************************");
			System.out.println("        宠物主人                                ");
			System.out.println("*************************");

			Scanner input = new Scanner(System.in);

			System.out.print("请输入姓名：");
			String name = input.next();
			System.out.print("请输入密码：");
			String password = input.next();//'小明'
			String sql = "select * from master where name='" + name
					+ "' and password= '" + password + "'";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getString(2)); 
			}
			
			System.out.print("登录成功，欢迎您");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
