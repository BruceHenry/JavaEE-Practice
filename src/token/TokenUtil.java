package token;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class TokenUtil {
	private TokenUtil(){}
	
	public static void saveToken(HttpServletRequest req){
		String token = UUID.randomUUID().toString();
		req.getSession().setAttribute("TOKEN_IN_SESSION", token);
		req.setAttribute("token", token);		
	}
	
	public static synchronized boolean validate(HttpServletRequest req, String token){
		String tokenInSession = (String)req.getSession().getAttribute("TOKEN_IN_SESSION");
		System.out.println("validate:"+tokenInSession);
		if(token.equals(tokenInSession)){
			req.getSession().removeAttribute("TOKEN_IN_SESSION");
			return true;
		}
		return false;		
	}
	

}
