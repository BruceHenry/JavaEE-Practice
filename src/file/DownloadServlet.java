package file;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = req.getParameter("file");
		String dir = super.getServletContext().getRealPath("/WEB-INF/file/");
		resp.setContentType("application/x-msdownload");
		File file = new File(dir, fileName);
		String userAgent = req.getHeader("User-Agent");//Get user's browser 
		if (userAgent.contains("MSIE")||userAgent.contains("Trident")||userAgent.contains("Edge"))// For IE(6, 11, Edge)
			fileName = URLEncoder.encode(fileName, "UTF-8");
		else//For Firefox, Chrome
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		Files.copy(Paths.get(file.getAbsolutePath()), resp.getOutputStream());
	}
}
