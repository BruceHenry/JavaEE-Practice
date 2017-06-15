package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		out.println("Welcome "+username);
		Cookie c = new Cookie("username", username);
		resp.addCookie(c);
		
		HttpSession session = req.getSession();
		session.setAttribute("USERNAME", username);
		String s = (String) session.getAttribute("USERNAME");
		System.out.println(s);
		session.setMaxInactiveInterval(10);
	}
}
