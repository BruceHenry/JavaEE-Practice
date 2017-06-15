package shoppingCart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String cmd = req.getParameter("cmd");
		if ("save".equals(cmd)) {
			this.save(req, resp);
		} else if ("delete".equals(cmd)) {
			this.delete(req, resp);
		}

	}

	protected void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		Integer num = Integer.valueOf(req.getParameter("num"));
		Item item = new Item();
		item.setName(name);
		item.setNum(num);
		if ("laptop".equals(name)) {
			item.setId("123");
			item.setPrice(1000.0);
		} else if ("keyboard".equals(name)) {
			item.setId("456");
			item.setPrice(100.0);
		} else if ("mouse".equals(name)) {
			item.setId("789");
			item.setPrice(10.0);
		}
		// whether in session
		Cart cart = (Cart) req.getSession().getAttribute("CART_IN_SESSION");
		if (cart == null) {
			cart = new Cart();
			req.getSession().setAttribute("CART_IN_SESSION", cart);
		}
		// sace item to session
		cart.save(item);
		System.out.println(cart);
		resp.sendRedirect("/cart/list.jsp");
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		// whether in session
		Cart cart = (Cart) req.getSession().getAttribute("CART_IN_SESSION");
		if (cart == null) {
			cart = new Cart();
			req.getSession().setAttribute("CART_IN_SESSION", cart);
		}
		cart.delete(id);
		resp.sendRedirect("/cart/list.jsp");
	}
	
}
