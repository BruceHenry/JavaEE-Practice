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

//@WebFilter("/*")
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
		//First thing to do: convert Servlet to HttpServlet
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        //Customized HttpServletRequest (Filter sensitive words)
        HttpServletRequest wrapperedRequest = new MyHttpServletRequest(req);


        // No encoding in request and encoding in Web.xml
        if ((req.getCharacterEncoding() == null || forceEncoding) && hasLength(encoding)) {
            req.setCharacterEncoding(encoding);
        }

        //instead of "chain.doFilter(req,resp);"
        chain.doFilter(wrapperedRequest, resp);


	}

	@Override
	public void destroy() {
		System.out.println("Destroy");
	}

	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}

}
