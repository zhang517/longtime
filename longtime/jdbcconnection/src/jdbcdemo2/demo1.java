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
 *第三方数据库连接池DBCP的应用 
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
			//这里的连接对象不同于DriverManager.getConnection中连接对象，
			//其close方法已经被改造
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
					//关闭存储查询结果的ResultSet对象
					rs.close();
				}
				if (stmt != null) {
					 //关闭负责执行SQL命令的Statement对象
					stmt.close();
				}
				if (con != null) {
					//注意：关闭后，将连接返还给连接池，而不是给数据库
					con.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}

	}
}
