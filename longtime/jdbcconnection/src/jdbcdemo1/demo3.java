package jdbcdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Administrator
 * ��ʾʾ��3��ʹ��Statement���³���
 */
public class demo3 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement  stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbcdemo", "root", "123456");
			stmt = conn.createStatement();
			
			String sql="update dog set health=50,love=10 where id=1";
			
			int result = stmt. executeUpdate(sql);
			if(result > 0){
				System.out.println("update into dog �ɹ�");
			}	

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��������ʧ��");
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
