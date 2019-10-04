package jdbcdemo2;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * @author Administrator
 *���������ݿ����ӳ�DBCP��Ӧ�� 
 */
public class demo1 {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs   = null;
		
		try {
			InputStream in = 
					demo1.class.getClassLoader().getResourceAsStream("jdbc.properties");
			Properties prop = new Properties();
			prop.load(in);

			DataSource ds = BasicDataSourceFactory.createDataSource(prop);
			//��������Ӷ���ͬ��DriverManager.getConnection�����Ӷ���
			//��close�����Ѿ�������
			con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from dog");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					//�رմ洢��ѯ�����ResultSet����
					rs.close();
				}
				if (stmt != null) {
					 //�رո���ִ��SQL�����Statement����
					stmt.close();
				}
				if (con != null) {
					//ע�⣺�رպ󣬽����ӷ��������ӳأ������Ǹ����ݿ�
					con.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}

	}
}
