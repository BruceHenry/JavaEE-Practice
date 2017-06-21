package file;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class FileUtil {
	private final static String[] ALLOWED_TYPE = { "png", "jpg", "gif", "bmp" };

	public static void upload(HttpServletRequest req,Map<String, String> map) {
		try {
			/* FileItemFactory like a form to handle every item in the form */
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// factory.setSizeThreshold(1024*10);
			// factory.setRepository(new File("D://temp"));

			/* To handle file */
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items = upload.parseRequest(req);
			for (FileItem item : items) {
				String fieldName = item.getFieldName();
				if (item.isFormField()) {// form field
					byte[] data = item.getString().getBytes("ISO-8859-1");
					String value = new String(data, "UTF-8");
					map.put(fieldName, value);
				} else {// file
					/*
					 * filename user uploaded (FilenameUtils.getName() for IE6)
					 */
					String fileName = FilenameUtils.getName(item.getName());
					String ext = FilenameUtils.getExtension(fileName);
					if (!Arrays.asList(ALLOWED_TYPE).contains(ext)) {
						throw new LogicException("Image type is wrong!");
					}

					// Get path of the project and dir of uploaded files
					String dir = req.getServletContext().getRealPath("/file");
					// Generate a random file name
					String randomFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(fileName);
					File file = new File(dir, randomFileName);
					item.write(file);
				}
			}

		} catch (LogicException e) {
			throw e;
		} catch (Exception e) {
			System.out.println("Something wrong in FileUtil.upload()!");
			e.printStackTrace();
		}
	}

}
