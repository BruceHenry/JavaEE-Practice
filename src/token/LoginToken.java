package token;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/token")
public class LoginToken extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		TokenUtil.saveToken(req);
		System.out.println("LoginToken:"+req.getSession().getAttribute("TOKEN_IN_SESSION").toString());
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

}
