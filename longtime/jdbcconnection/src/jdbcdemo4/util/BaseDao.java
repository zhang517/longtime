package jdbcdemo4.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * ���ݿ�������رչ����ࡣ
 */
public class BaseDao {
	private static String driverClassName; // ���ݿ������ַ���
	private static String url; // ����URL�ַ���
	private static String username; // ���ݿ��û���
	private static String password; // �û�����

	static {// ��̬�����,������ص�ʱ��ִ��
		init();
	}

	/**
	 * ��ʼ�����Ӳ���,�������ļ�����
	 */
	public static void init() {
		Properties params = new Properties();
		String configFile = "jdbc.properties";// �����ļ�·��
		// ���������ļ�����������
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(
				configFile);

		try {
			// ���������ж�ȡ�����б�
			params.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ����ָ���Ļ�ȡ��Ӧ��ֵ
		driverClassName = params.getProperty("driverClassName");
		url = params.getProperty("url");
		username = params.getProperty("username");
		password = params.getProperty("password");
	}

	/**
	 * ��ȡ���ݿ����Ӷ���
	 */
	public Connection getConnection() {
		Connection conn = null;
		// ��ȡ���Ӳ������쳣
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();// �쳣����
		}
		return conn;// �������Ӷ���
	}

	/**
	 * �ر����ݿ����ӡ�
	 * 
	 * @param conn
	 *            ���ݿ�����
	 * @param stmt
	 *            Statement����
	 * @param rs
	 *            �����
	 */
	public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		// �����������Ϊ�գ���ر�
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ��Statement����Ϊ�գ���ر�
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// �����ݿ����Ӷ���Ϊ�գ���ر�
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ����ɾ���ĵĲ���
	 * 
	 * @param sql
	 *            Ԥ����� SQL ���
	 * @param param
	 *            Ԥ����� SQL ����еġ������������ַ�������
	 * @return Ӱ�������
	 */
	public int exceuteUpdate(String preparedSql, Object[] param) {
		PreparedStatement pstmt = null;
		int num = 0;
		Connection conn = getConnection();
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // ΪԤ����sql���ò���
				}
			}
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return num;
	}

}
