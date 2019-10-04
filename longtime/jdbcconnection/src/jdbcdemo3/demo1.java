package jdbcdemo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Administrator
 * ��ʾʾ��1����ʾJDBC����ε�������
 */
public class demo1 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement  stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbcdemo", "root", "123456");
			conn.setAutoCommit(false);//ȡ���Զ��ύ
			stmt = conn.createStatement();
			
			String sql="update dog set health=102,love=16 where id=1";
			
			int result = stmt. executeUpdate(sql);
			if(result > 0){
				System.out.println("update into dog �ɹ�");
			}	
			
			//ģ���ָ��
			//String st = null;
			//st.length();
			
            sql="update master set money=92 where id=1";
			
            result = stmt. executeUpdate(sql);
			if(result > 0){
				System.out.println("update into master �ɹ�");
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
