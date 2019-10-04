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
 * 数据库连接与关闭工具类。
 */
public class BaseDao {
	private static String driverClassName; // 数据库驱动字符串
	private static String url; // 连接URL字符串
	private static String username; // 数据库用户名
	private static String password; // 用户密码

	static {// 静态代码块,在类加载的时候执行
		init();
	}

	/**
	 * 初始化连接参数,从配置文件里获得
	 */
	public static void init() {
		Properties params = new Properties();
		String configFile = "jdbc.properties";// 配置文件路径
		// 加载配置文件到输入流中
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(
				configFile);

		try {
			// 从输入流中读取属性列表
			params.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 根据指定的获取对应的值
		driverClassName = params.getProperty("driverClassName");
		url = params.getProperty("url");
		username = params.getProperty("username");
		password = params.getProperty("password");
	}

	/**
	 * 获取数据库连接对象。
	 */
	public Connection getConnection() {
		Connection conn = null;
		// 获取连接并捕获异常
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();// 异常处理
		}
		return conn;// 返回连接对象
	}

	/**
	 * 关闭数据库连接。
	 * 
	 * @param conn
	 *            数据库连接
	 * @param stmt
	 *            Statement对象
	 * @param rs
	 *            结果集
	 */
	public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		// 若结果集对象不为空，则关闭
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 若Statement对象不为空，则关闭
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 若数据库连接对象不为空，则关闭
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 增、删、改的操作
	 * 
	 * @param sql
	 *            预编译的 SQL 语句
	 * @param param
	 *            预编译的 SQL 语句中的‘？’参数的字符串数组
	 * @return 影响的行数
	 */
	public int exceuteUpdate(String preparedSql, Object[] param) {
		PreparedStatement pstmt = null;
		int num = 0;
		Connection conn = getConnection();
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
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
