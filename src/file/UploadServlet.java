package file;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (!isMultipart) {
			System.out.println("enctype should be 'multipart/form-data'");
			return;
		}
		try {
			/*Use a map to store fields in the form*/
			Map<String, String> map = new HashMap<String, String>();
			FileUtil.upload(req, map);
			System.out.println(map);
		} catch (LogicException e) {
			req.setAttribute("errorMSG", e.getMessage());
			req.getRequestDispatcher("/upload.jsp").forward(req, resp);
		}

	}
}
