package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class DB extends HttpServlet {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/test-schema?useSSL=true";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			String cmd = req.getParameter("cmd");
			if ("update".equals(cmd))
				update(req, resp, stmt);
			else if ("edit".equals(cmd))
				edit(req, resp);
			else if ("add".equals(cmd))
				add(req, resp, stmt);
			else if ("delete".equals(cmd))
				delete(req, resp, stmt);
			else
				list(req, resp, stmt);
		} catch (Exception e) {
			System.out.println("Something wrong!");
		}
	}

	public void list(HttpServletRequest req, HttpServletResponse resp, Statement stmt)
			throws ServletException, IOException, SQLException {
		ArrayList<User> list = new ArrayList<User>();
		String sql = "SELECT * FROM user";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			list.add(new User(rs.getString("name"), rs.getInt("age"), rs.getString("password")));
		}
		req.getSession().setAttribute("list", list);
		req.getRequestDispatcher("/userList.jsp").forward(req, resp);
	}

	public void add(HttpServletRequest req, HttpServletResponse resp, Statement stmt)
			throws ServletException, IOException, SQLException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String password = req.getParameter("password");
		String sql = String.format("insert into user values('%s',%s,'%s')", name, age, password);
		int rs = stmt.executeUpdate(sql);
		System.out.println(rs + " record added.");
		resp.sendRedirect(req.getContextPath() + "/user");
	}

	public void delete(HttpServletRequest req, HttpServletResponse resp, Statement stmt)
			throws ServletException, IOException, SQLException {
		String name = req.getParameter("name");
		String sql = String.format("delete FROM user where name='%s'", name);
		int rs = stmt.executeUpdate(sql);
		System.out.println(rs + " record deleted.");

		resp.sendRedirect(req.getContextPath() + "/user");
	}

	protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().setAttribute("name", req.getParameter("name"));
		req.getSession().setAttribute("age", req.getParameter("age"));
		req.getRequestDispatcher("/edit.jsp").forward(req, resp);
	}

	public void update(HttpServletRequest req, HttpServletResponse resp, Statement stmt)
			throws ServletException, IOException, SQLException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String oldName = (String) req.getSession().getAttribute("name");
		String oldAge = (String) req.getSession().getAttribute("age");
		String sql = String.format("update user set name='%s',age=%s where name='%s' and age = %s", name, age, oldName,
				oldAge);
		int rs = stmt.executeUpdate(sql);
		System.out.println(rs + " record updated.");
		resp.sendRedirect(req.getContextPath() + "/user");
	}
}
