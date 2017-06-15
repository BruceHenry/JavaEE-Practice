package jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/base/*")
public class Base extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
//		req.getRequestDispatcher("/forward/").forward(req, resp);
		
//		resp.sendRedirect("/redirect/");
//		resp.sendRedirect("https://www.google.com/");
		
		req.getRequestDispatcher("/include/").include(req, resp);
		
		out.println("Base");
		System.out.println(req.getContextPath());
		
		System.out.println("Base");
	}
}
