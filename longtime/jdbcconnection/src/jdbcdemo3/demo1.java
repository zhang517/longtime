package jdbcdemo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Administrator
 * 演示示例1：演示JDBC中如何调用事务
 */
public class demo1 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement  stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbcdemo", "root", "123456");
			conn.setAutoCommit(false);//取消自动提交
			stmt = conn.createStatement();
			
			String sql="update dog set health=102,love=16 where id=1";
			
			int result = stmt. executeUpdate(sql);
			if(result > 0){
				System.out.println("update into dog 成功");
			}	
			
			//模拟空指针
			//String st = null;
			//st.length();
			
            sql="update master set money=92 where id=1";
			
            result = stmt. executeUpdate(sql);
			if(result > 0){
				System.out.println("update into master 成功");
			}	
		
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
