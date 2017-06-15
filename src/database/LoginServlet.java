package database;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		User user=null;
		try {
			user = UserDAO.checkLogin(name, password);
		} catch (SQLException e) {
			System.out.println("Something wrong!");
		}
		if(user==null){
			req.setAttribute("errorMsg", "Username/Password is wrong");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		req.getSession().setAttribute("USER_IN_SESSION", user);
		req.getRequestDispatcher("/user").forward(req, resp);
		System.out.println("Succeed in login!");

	}

}
