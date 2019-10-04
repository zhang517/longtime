package jdbcdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Administrator 演示示例2：使用Statement添加宠物
 */
public class demo2 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbcdemo", "root", "123456");
			stmt = conn.createStatement();

			// String name = "花花";
			// int health = 1;
			// int love = 50;
			// String strain = "藏獒";

			String name = "贝贝2";
			int health = 3;
			int love = 90;
			String strain = "哈士奇";
			
			StringBuffer sbSql = new StringBuffer(
					"insert into dog (name,health,love,strain) values ( '");
			sbSql.append(name + "',");
			sbSql.append(health + ",");
			sbSql.append(love + ",'");
			sbSql.append(strain + "')");
			
			System.out.println(sbSql.toString());
			stmt.execute(sbSql.toString());
			// stmt. executeUpdate(sbSql.toString());
			System.out.println("insert into dog 成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库异常");
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
