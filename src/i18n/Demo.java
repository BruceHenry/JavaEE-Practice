package i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class Demo {
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("myApp",Locale.CHINA);
		System.out.println(rb.getString("password"));		
	}
}
