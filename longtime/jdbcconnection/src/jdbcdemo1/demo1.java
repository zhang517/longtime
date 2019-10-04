package jdbcdemo1;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

/**
 * @author Administrator
 * ��ʾʾ��1��ʹ�ô�Java��ʽ�������
 */
/**
 * @author Administrator
 *alt+shift+j
 */

public class demo1 {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("��������ʧ��");
		}

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbcdemo?useUnicode=true&characterEncoding=utf-8", "root", "123456");
			System.out.println("�������ӳɹ�");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��������ʧ��");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
