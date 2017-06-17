package randomCode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/randomcode/*")
public class RandomCode extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String randomCode = UUID.randomUUID().toString().substring(0, 5);
		req.getSession().setAttribute("RANDOMCODE_IN_SESSION", randomCode);
		int width = 80;
		int height = 40;
		int imageType = BufferedImage.TYPE_INT_RGB;
		BufferedImage image = new BufferedImage(width, height, imageType);
		Graphics g = image.getGraphics();
		g.setColor(Color.yellow);
		g.fillRect(1, 1, width - 2, height - 2);
		g.setColor(Color.black);
		Font font = new Font("TimesRoman", Font.BOLD + Font.ITALIC, 20);
		g.setFont(font);
		g.drawString(randomCode, 10, 30);
		g.setColor(Color.gray);
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			g.fillRect(r.nextInt(width), r.nextInt(height), 2, 2);
		}
		g.dispose();
		ImageIO.write(image, "jpg", resp.getOutputStream());
	}
}
