package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class FilterDemo01 implements javax.servlet.Filter {
	private String encoding = null;
	private boolean forceEncoding = false;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter("encoding");
		this.forceEncoding = Boolean.valueOf(filterConfig.getInitParameter("force"));
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		// No encoding in request and encoding in Web.xml
		if ((req.getCharacterEncoding() == null || forceEncoding) && hasLength(encoding)) {
			req.setCharacterEncoding(encoding);
		}
		chain.doFilter(req, resp);

	}

	@Override
	public void destroy() {
		System.out.println("Destroy");
	}

	private boolean hasLength(String str) {
		return str != null && "".equals(str.trim());
	}

}
