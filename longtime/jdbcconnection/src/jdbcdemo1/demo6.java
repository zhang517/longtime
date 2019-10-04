package jdbcdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Administrator 
 * ��ʾʾ��6��ʹ��PreparedStatement���³��� 
 */
public class demo6 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbcdemo", "root", "123456");
			// ���¹�����Ϣ�����ݿ�
			String sql="update dog set health=?,love=? where id=?";
		    pstmt = conn.prepareStatement(sql);
	
		    pstmt.setInt(1, 100);
		    pstmt.setInt(2, 52);
		    pstmt.setInt(3, 1);
		    
		    int result = pstmt.executeUpdate();
		    if(result > 0){
				System.out.println("update into dog �ɹ�");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
