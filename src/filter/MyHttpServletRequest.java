package filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyHttpServletRequest extends HttpServletRequestWrapper {

	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name){
		String value =  super.getParameter(name);
		if("title".equals(name)){
			value = filter(value);// Filter sensitive words (should be from another package)
		}
		return value;
	}

	private String filter(String ret) {
		// Filter sensitive words
		return "123";
	}

}
