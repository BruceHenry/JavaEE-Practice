package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calc extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		out.println("<form action='/cal' method='post'>");
		out.println("First value:<input type='text' name='first' value='0'><br>");
		out.println("<select name='calc'><option value='+'>+</option><option value='-'>-</option></select><br>");
		out.println("Second value:<input type='text' name='second' value='0'><br>");
		out.println("<input type='submit' value='Calculate'><br>");
		out.println("<b>Result:</b>");
		if (req.getMethod().equals("POST")) {
			Integer first = Integer.parseInt(req.getParameter("first") != "" ? req.getParameter("first") : "0");
			Integer second = Integer.parseInt(req.getParameter("second") != "" ? req.getParameter("second") : "0");
			String calc = req.getParameter("calc");
			Integer result;
			System.out.println(calc);
			switch (calc) {
			case "+":
				result = first + second;
				break;
			case "-":
				result = first - second;
				break;
			default:
				result = Integer.MIN_VALUE;
			}
			out.println(first + calc + second + " = " + result);
		}
	}
}
