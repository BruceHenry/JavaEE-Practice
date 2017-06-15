package bean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapConvert {
	public static Map<String, Object> beanToMap(Object obj) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		BeanInfo bi = Introspector.getBeanInfo(obj.getClass(), Object.class);
		PropertyDescriptor[] pds = bi.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			String propertyName = pd.getName();
			Object propertyValue = pd.getReadMethod().invoke(obj);
			map.put(propertyName, propertyValue);
		}
		return map;
	}

	public static Object mapToBean(Map<String, Object> map, Class type) throws Exception {
		Object obj = type.newInstance();
		BeanInfo bi = Introspector.getBeanInfo(type, Object.class);
		PropertyDescriptor[] pds = bi.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			String propertyName = pd.getName();
			Object propertyValue = map.get(propertyName);
			pd.getWriteMethod().invoke(obj, propertyValue);
		}
		return obj;
	}

	public static void main(String[] args) throws Exception {
		Person p = new Person("BaoHan", 18);
		
		Map<String, Object> map = beanToMap(p);
		System.out.println(map);
		
		Person p2 = (Person) mapToBean(map, Person.class);
		System.out.println(p2);
	}
}
