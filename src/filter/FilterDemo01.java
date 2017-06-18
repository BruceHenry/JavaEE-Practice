package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class FilterDemo01 implements javax.servlet.Filter {
	public FilterDemo01() {
		System.out.println("...Constructor...");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Do Filter");
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		System.out.println("Destroy");
	}

}
