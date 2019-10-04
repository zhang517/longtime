package jdbcdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


/**
 * @author Administrator ��ʾʾ��5��SQLע������
 */
public class demo5nosql {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbcdemo", "root", "123456");
			
			System.out.println("*************************");
			System.out.println("        ��������                                ");
			System.out.println("*************************");

			Scanner input = new Scanner(System.in);

			System.out.print("������������");
			String name = input.next();
			System.out.print("���������룺");
			String password = input.next();
			
			String sql = "select * from master where name = ? and password = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			
			System.out.println(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(2)); 
			}
			
			System.out.print("��¼�ɹ�����ӭ��");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
