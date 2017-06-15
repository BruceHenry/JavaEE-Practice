package bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class IntrospectorDemo {
	public static void main(String[] args)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		BeanInfo bi = Introspector.getBeanInfo(Person.class);
		PropertyDescriptor[] pds = bi.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			System.out.println(pd.getPropertyType() + "---" + pd.getName());
		}
		Person p = new Person();
		p.setName("BaoHan");
		String name = BeanUtils.getProperty(p, "name");
		System.out.println(name);
	}
}
