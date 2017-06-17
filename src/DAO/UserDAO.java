package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.User;

public class UserDAO {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/test-schema?useSSL=true";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static User checkLogin(String name, String password) throws SQLException {
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
		} catch (Exception e) {
			System.out.println("Something wrong in JDBC!");
		}
		String sql = String.format("SELECT * FROM user WHERE name = '%s' AND password = '%s'", name, password);
		System.out.println(sql);
		ArrayList<User> list = new ArrayList<User>();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			list.add(new User(rs.getString("name"),rs.getInt("age"), rs.getString("password")));
		}
		return list.size() == 1 ? list.get(0) : null;
	}

//	public static void main(String[] args) throws SQLException {
//		UserDAO ud = new UserDAO();
//		System.out.println(ud.checkLogin("baohan", "123"));
//	}
}
