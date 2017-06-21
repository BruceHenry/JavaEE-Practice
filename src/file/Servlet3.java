package file;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.lang3.StringUtils;

@WebServlet("/upload3")
@MultipartConfig()
public class Servlet3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		Part IMGpart = req.getPart("IMG");
		String dir = req.getServletContext().getRealPath("/file");//Project path
		String content = IMGpart.getHeader("Content-Disposition");//file name is inside
		String fileName = StringUtils.substringBetween(content, "filename=\"", "\"");
		IMGpart.write(new File(dir, fileName).getAbsolutePath());
	}
}
